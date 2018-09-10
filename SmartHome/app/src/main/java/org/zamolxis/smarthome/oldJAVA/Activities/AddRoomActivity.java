package com.example.zizzz.controlapp.Activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zizzz.controlapp.DataBases.DataBaseHandler;
import com.example.zizzz.controlapp.R;
import com.example.zizzz.controlapp.Room;

/**
 *Created by Neacsu Antoniu 6/9/2018
 */

public class AddRoomActivity extends AppCompatActivity {

    private Button roomIconB;
    private Button finishB;

    private EditText roomNameET;

    private ImageView backIV;
    private ImageView chooseImageIV;


    //uri si path pt imagine
    Uri selectedImage;
    String filePathColumn;

    public Uri getSelectedImage() {
        return selectedImage;
    }
    public void setSelectedImage(Uri selectedImage) {
        this.selectedImage = selectedImage;
    }
    public String getFilePathColumn() {
        return filePathColumn;
    }
    public void setFilePathColumn(String filePathColumn) {
        this.filePathColumn = filePathColumn;
    }




    //iau pathul de la imaginea selectata
    int PICK_IMAGE = 1;
    int STORAGE_PERMISSION_CODE = 1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                //Error
                Toast.makeText(this, "Error on trying to get image", Toast.LENGTH_LONG).show();
                return;
            }

            //store the image & path
            this.setSelectedImage(data.getData());
            this.setFilePathColumn(selectedImage.getPath());
            chooseImageIV.setImageURI(selectedImage);
        }//if
    }
    //-----------------------------------



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == STORAGE_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission OK", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);//
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
            else{
                Toast.makeText(this, "Permission REQUESTED. Try again", Toast.LENGTH_LONG).show();
            }
        }
    }

    //OnCreate
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        //butoane, tv, iv
        roomIconB = (Button)findViewById(R.id.roomIconButton);
        finishB = (Button)findViewById(R.id.finishButton);
        roomNameET = (EditText)findViewById(R.id.roomEditText);
        backIV = (ImageView)findViewById(R.id.backImage);
        chooseImageIV = (ImageView) findViewById(R.id.chooseImage);



        //onClicks
        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRoomActivity.this, SelectingActivity.class);
                startActivity(intent);
            }
        });


        //apas pe buton de add room si imi deschide pozele
        roomIconB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //permission granted already
                if(ActivityCompat.checkSelfPermission(AddRoomActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)
                   == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);//
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
                }
                else{
                    ActivityCompat.requestPermissions(AddRoomActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                }


            }
        });

        //FINISH BUTTON
        finishB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aici ar trebui cumva sa avem o metoda care sa atribuie fiecarei camere un id
                //gen room.setId(giveId());
                //ca atunci cand sterge o camera se elibereaza id-ul. Daca nu doar crestem asa id-urile
                Room room = new Room();
                //room set
                room.setName(roomNameET.getText().toString());
                room.setRoom_id(Room.getLastId());
                room.setRoom_icon(filePathColumn);
                Room.setLastId();

                //room bar elements
                try {
                    Toast.makeText(getApplicationContext(), "selectedImage : "
                            + filePathColumn
                            , Toast.LENGTH_LONG).show();
                    room.setRoomIconIV(selectedImage);//zzzz
                    room.setRoomNameTV(roomNameET.getText().toString());
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "EROARE: "
                            + e.getMessage().toString(), Toast.LENGTH_LONG).show();
                }


                //Adaugam in baza de date tot roomul
                DataBaseHandler dbHandler = new DataBaseHandler(getApplicationContext(), null, null, 1);
                try {
                    dbHandler.addRoom(room);
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Camera NU a fost adaugata: "
                            + e.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
                finally {
                    Toast.makeText(getApplicationContext(), "Camera a fost adaugata: " , Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
