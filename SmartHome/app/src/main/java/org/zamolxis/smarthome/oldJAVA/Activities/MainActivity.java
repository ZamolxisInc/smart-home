package com.example.zizzz.controlapp.Activities;

/**
 *Created by Neacsu Antoniu 1/9/2018
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zizzz.controlapp.R;
import com.example.zizzz.controlapp.Room;

public class MainActivity extends AppCompatActivity {

    private EditText IdField;
    private EditText PasswordField;
    private TextView Wrong;
    private Button LoginButton;

    //unde vezi o variabila ca se termina cu TV = TextView, IV = ImageView samd

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IdField = (EditText)findViewById(R.id.fLoginID);
        PasswordField = (EditText)findViewById(R.id.fPassword);
        LoginButton = (Button)findViewById(R.id.bLogin);
        Wrong = (TextView)findViewById(R.id.Wrongf);

        LoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkLogin(IdField.getText().toString(), PasswordField.getText().toString());
            }
        });
    }



    private void checkLogin(String id, String passw){
        if(true){
            //change activity
            Room[] rooms = new Room[3];

            Intent intent = new Intent(MainActivity.this, SelectingActivity.class);
            startActivity(intent);
        }
        else{
            Wrong.setText("ID sau parola gresite");
        }
    }
}
