package com.example.zizzz.controlapp.Activities;

/**
 *Created by Neacsu Antoniu 1/9/2018
 */


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.zizzz.controlapp.DataBases.DataBaseHandler;
import com.example.zizzz.controlapp.R;

public class SelectingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting);

        //Baza de date
        DataBaseHandler dbHandler = new DataBaseHandler(getApplicationContext(), null, null, 1);



        //OnClicks
        Button addRoom = (Button)findViewById(R.id.addRoomButton);
        addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectingActivity.this, AddRoomActivity.class);
                startActivity(intent);
            }
        });
    }

}
