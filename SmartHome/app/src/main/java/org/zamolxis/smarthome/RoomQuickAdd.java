package org.zamolxis.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RoomQuickAdd extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvcategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        tvtitle = (TextView) findViewById(R.id.txtroom);
        img = (ImageView) findViewById(R.id.room_name);

        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        int image = intent.getExtras().getInt("Thumbnail") ;

        // Setting values

        tvtitle.setText(Title);
        img.setImageResource(image);


    }
}

