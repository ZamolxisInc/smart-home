package org.zamolxis.smarthome;

import java.net.MalformedURLException;
import java.net.URL;

public class CommandDevice {

    private String name;
    private String METHOD;
    private URL url;//sa adaug permisiune android.permission.internet
    private String stringURL;
    String[] executeUsing = {
            "URL",
            "Add application"
    };


    /*<---------------------| Getters/Setters |--------------------->*/
    public String getMETHOD() {
        return METHOD;
    }

    public void setMETHOD(String METHOD) {
        this.METHOD = METHOD;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(String stringURL) {
        try {
            this.url = new URL(stringURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
