package org.zamolxis.smarthome.oldJAVA;

/**
 *Created by Neacsu Antoniu 5/9/2018
 */

import android.widget.ImageView;
import android.widget.TextView;

public class Device {

    String device_name;
    int device_id;
    int device_id_room;
    String device_icon;
    int OnOff;

    //Imagine pt device
    ImageView DeviceIconTV;
    TextView DeviceNameTV;

    //getters and setters
    //uita-te tu sa fie ok daca nu le stergere si fa-le automat pe toate iar
    public String getDevice_name () {
        return device_name;
    }

    public void setDevice_name (String device_name){
        this.device_name = device_name;
    }

    public int getDevice_id () {
        return device_id;
    }

    public void setDevice_id ( int device_id){
        this.device_id = device_id;
    }

    public int getDevice_id_room () {
        return device_id_room;
    }

    public void setDevice_id_room ( int device_id_room){
        this.device_id_room = device_id_room;
    }

    public String getDevice_icon () {
        return device_icon;
    }

    public void setDevice_icon ( String device_icon){
        this.device_icon = device_icon;
    }

    public int getOnOff () {
        return OnOff;
    }

    public void setOnOff ( int onOff){
        OnOff = onOff;
    }

    public ImageView getDeviceIconTV() {
            return DeviceIconTV;
    }

    public void setDeviceIconTV(ImageView deviceIconTV) {
            DeviceIconTV = deviceIconTV;
        }

        public TextView getDeviceNameTV() {
            return DeviceNameTV;
        }

     public void setDeviceNameTV(String device_name) {
            DeviceNameTV.setText(device_name);
        }
}
