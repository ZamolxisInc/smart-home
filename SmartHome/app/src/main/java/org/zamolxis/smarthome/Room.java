package org.zamolxis.smarthome;

import android.net.Uri;

public class Room {

    static int lastId = 0;
    private int id;
    private String name;
    private String imagePath;

    public Room() {
    }

    public Room(String name, String imagePath) {
        name = this.name;
        imagePath = this.imagePath;
    }


    public String getName() {
        return name;
    }

    public Uri getImagePathUri(){
        Uri u =  Uri.parse(this.getImagePath());
        return u;
    }

    public String getImagePath() {
        return imagePath;
    }


    public void setName(String name) {
        name = this.name;
    }

    public void setImagePath(String imagePath) {
        imagePath = this.imagePath;
    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Room.lastId = lastId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
