package org.zamolxis.smarthome;

public class Room {

    private String title;
    private int thumbnail;

    public Room() {
    }

    public Room(String title, int thumbnail) {
        title = this.title;
        thumbnail = this.thumbnail;
    }


    public String getTitle() {
        return title;
    }

    public int getThumbnail() {
        return thumbnail;
    }


    public void setTitle(String title) {
        title = this.title;
    }

    public void setThumbnail(int thumbnail) {
        thumbnail = this.thumbnail;
    }
}
