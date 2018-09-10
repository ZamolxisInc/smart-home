package org.zamolxis.smarthome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Room> roomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roomList = new ArrayList<>();
        roomList.add(new Room("The Vegitarian",R.drawable.thevigitarian));
        roomList.add(new Room("The Wild Robot",R.drawable.thewildrobot));
        roomList.add(new Room("Maria Semples",R.drawable.mariasemples));
        roomList.add(new Room("The Martian",R.drawable.themartian));
        roomList.add(new Room("He Died with...",R.drawable.hediedwith));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,roomList);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }
}
