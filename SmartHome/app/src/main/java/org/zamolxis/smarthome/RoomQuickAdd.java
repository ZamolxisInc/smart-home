package org.zamolxis.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RoomQuickAdd extends AppCompatActivity {

    private TextView roomName;
    private ImageView roomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        roomName = (TextView) findViewById(R.id.room_name_id);
        roomImage = (ImageView) findViewById(R.id.room_image_id);

        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        int image = intent.getExtras().getInt("Thumbnail") ;

        // Setting values

        roomName.setText(Title);
        roomImage.setImageResource(image);


    }
}

