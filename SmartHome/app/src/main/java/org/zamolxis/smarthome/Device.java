package org.zamolxis.smarthome;

public class Device {
    String deviceName;
    int deviceID;
    int deviceIDRoom;
    String thumbnail;


    //getters and setters
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID){
        this.deviceID = deviceID;
    }

    public int getDeviceIDRoom() {
        return deviceIDRoom;
    }

    public void setDeviceIDRoom(int deviceIDRoom){
        this.deviceIDRoom = deviceIDRoom;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail){
        this.thumbnail = thumbnail;
    }
}
