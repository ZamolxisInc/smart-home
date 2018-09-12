package org.zamolxis.smarthome;


/**
 *Created by Neacsu Antoniu 5/9/2018
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


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


    //constructor
    public DataBaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }


    /*<---------------------| Override |--------------------->*/
    @Override
    public void onCreate(SQLiteDatabase db) {


        String Query_room = "CREATE TABLE IF NOT EXISTS " + TABLE_ROOMS + "(" +
                COLUMN_ROOM_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ROOM_NAME + " text, " +
                COLUMN_ROOM_IMAGE + " TEXT );";


        String Query_device = "CREATE TABLE  IF NOT EXISTS " + TABLE_DEVICES + "(" +
                COLUMN_DEVICE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DEVICE_ROOM_ID + " TEXT, " +
                COLUMN_DEVICE_NAME + " TEXT, " +
                COLUMN_DEVICE_IMAGE + " TEXT ," +
                "UNIQUE(" + COLUMN_ROOM_NAME + ")" + ");";

        //Create tables
        db.execSQL(Query_room);
        db.execSQL(Query_device);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEVICES);
        onCreate(db);
    }


    /*<---------------------| ADD / DELETE |--------------------->*/
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
        values.put(COLUMN_DEVICE_IMAGE, device.getThumbnail());

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


    /*<---------------------| ADD / DELETE |--------------------->*/
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

        return tableString;
    }


}