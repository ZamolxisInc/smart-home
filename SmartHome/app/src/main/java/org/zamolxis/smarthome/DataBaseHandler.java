package org.zamolxis.smarthome;

/**
 *Created by Neacsu Antoniu 5/9/2018
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.File;


public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "SmartHome.db";

    //ROOMS
    private static final String TABLE_ROOMS = "rooms";
    private static final String COLUMN_ROOM_ID = "ROOM_ID";
    private static final String COLUMN_ROOM_NAME = "ROOM_NAME";
    private static final String COLUMN_ROOM_IMAGE = "location";

    //DEVICES
    private static final String TABLE_DEVICES = "devices";
    private static final String COLUMN_DEVICE_ID = "DEVICE_ID";
    private static final String COLUMN_DEVICE_ROOM_ID = "DEVICE_ID_ROOM";
    private static final String COLUMN_DEVICE_NAME = "DEVICE_NAME";
    private static final String COLUMN_DEVICE_IMAGE = "location";


    private Context context;
    //SQLiteDatabase db = getWritableDatabase();





    /*<---------------------| CONSTRUCTOR |--------------------->*/
    public DataBaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }





    /*<---------------------| Override |--------------------->*/
    @Override
    public void onCreate(SQLiteDatabase db) {

        String Query_room = "CREATE TABLE IF NOT EXISTS " + TABLE_ROOMS + "(" +
                COLUMN_ROOM_ID + " integer PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_ROOM_NAME + " text NOT NULL, " +
                COLUMN_ROOM_IMAGE + " TEXT NOT NULL );";


        String Query_device = "CREATE TABLE  IF NOT EXISTS " + TABLE_DEVICES + "(" +
                COLUMN_DEVICE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_DEVICE_ROOM_ID + " TEXT NOT NULL, " +
                COLUMN_DEVICE_NAME + " TEXT NOT NULL, " +
                COLUMN_DEVICE_IMAGE + " TEXT NOT NULL" + ");";

        Toast.makeText(context, "OnCreate()", Toast.LENGTH_LONG).show();

        try {
            //Create tables
            db.execSQL(Query_room);
        }
        catch (Exception e){
            Toast.makeText(context, "Room Query Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        try {
            //Create tables
            db.execSQL(Query_device);
        }
        catch (Exception e){
            Toast.makeText(context, "Device Query Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        this.checkDBexists();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Toast.makeText(context, "OnUpdate()", Toast.LENGTH_LONG).show();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEVICES);
        onCreate(db);
    }





    /*<---------------------| ADD / DELETE / EXEC QUERY |--------------------->*/
    //Add ROW
    public void addRoom(Room room) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        //add values
        values.put(COLUMN_ROOM_ID, room.getId());
        values.put(COLUMN_ROOM_NAME, room.getName());
        values.put(COLUMN_ROOM_IMAGE, room.getImagePath());

        //add to table
        db.insert(TABLE_ROOMS, null, values);
        db.close();
    }

    public void addDevice(Device device) {
        ContentValues values = new ContentValues();

        //add values
        values.put(COLUMN_DEVICE_ID, device.getDeviceID());
        values.put(COLUMN_DEVICE_ROOM_ID, device.getDeviceIDRoom());
        values.put(COLUMN_DEVICE_NAME, device.getDeviceName());
        values.put(COLUMN_DEVICE_IMAGE, device.getImagePath());

        //add to table
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_DEVICES, null, values);
        db.close();
    }

    //Delete ROW
    public void deleteRoom(Room room) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ROOMS + " WHERE " + COLUMN_ROOM_NAME + " =\"" + room.getName() + "\"");
        db.close();
    }

    public void deleteDevice(Device device) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_DEVICES + " WHERE " + COLUMN_ROOM_NAME + " =\"" + device.getDeviceName() + "\"");
        db.close();
    }

    //Exec any query
    public void executeQuery(String q, SQLiteDatabase db){
        try{
            db.execSQL(q);
        }
        catch (Exception e){
            Toast.makeText(context, "Failed to execute query", Toast.LENGTH_LONG).show();
        }

    }





    /*<---------------------| PRINT |--------------------->*/
    public String getTableAsString(SQLiteDatabase db) {
        String tableString = String.format("Table %s:\n", TABLE_ROOMS);
        Cursor allRows = db.rawQuery("SELECT * FROM " + TABLE_ROOMS, null);
        if (allRows.moveToFirst()) {
            String[] columnNames = allRows.getColumnNames();
            do {
                for (String name : columnNames) {
                    tableString += String.format("%s: %s\n", name,
                            allRows.getString(allRows.getColumnIndex(name)));
                }
                tableString += "\n";

            } while (allRows.moveToNext());
        }
        allRows.close();
        return tableString;
    }





    /*<---------------------|CHECKERS |--------------------->*/
    public void checkDBexists(){
        File dbFile = context.getDatabasePath(DB_NAME);
        if( dbFile.exists() ){
            Toast.makeText(context, "DB exists", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "Error: DB doesn't exist", Toast.LENGTH_LONG).show();
        }
    }

}