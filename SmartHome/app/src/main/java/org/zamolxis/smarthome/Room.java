package org.zamolxis.smarthome;

import android.net.Uri;

public class Room {

    static int lastId = 0;
    private int id;
    private String name;
    private String thumbnail;

    public Room() {
    }

    public Room(String name, String thumbnail) {
        name = this.name;
        thumbnail = this.thumbnail;
    }


    public String getName() {
        return name;
    }

    public Uri getThumbnailUri(){
        Uri u =  Uri.parse(this.getThumbnail());
        return u;
    }

    public String getThumbnail() {
        return thumbnail;
    }


    public void setName(String name) {
        name = this.name;
    }

    public void setThumbnail(String thumbnail) {
        thumbnail = this.thumbnail;
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
