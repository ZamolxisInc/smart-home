package org.zamolxis.smarthome.oldJAVA;

/**
 *Created by Neacsu Antoniu 5/9/2018
 */

import android.graphics.drawable.Icon;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Room {

    static int lastId = 0;
    String name;
    int room_id;
    String room_icon;

    //Room Bar Elements
    ImageView RoomIconIV;
    TextView RoomNameTV;

    //constructors
    public Room(){
        this.room_icon = "no_location";
        this.room_id = lastId++;
        this.name = "Room " + lastId;
    }

    //getters and setters


    public static int getLastId() {
        return lastId;
    }

    public static void setLastId() {
        Room.lastId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_icon() {
        return room_icon;
    }

    public void setRoom_icon(String room_icon) {
        this.room_icon = room_icon;
    }

    public ImageView getRoomIconIV() {
        return RoomIconIV;
    }

    public void setRoomIconIV(Uri uri) {
            this.RoomIconIV.setImageURI(uri);
    }

    public TextView getRoomNameTV() {
        return RoomNameTV;
    }

    public void setRoomNameTV(String text) {
        RoomNameTV.setText(text);
    }
}
