package org.zamolxis.smarthome.oldJAVA.Adaptors;

/**
 *Created by Neacsu Antoniu 6/9/2018
 */

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zizzz.controlapp.R;
import com.example.zizzz.controlapp.Room;

import org.zamolxis.smarthome.R;
import org.zamolxis.smarthome.oldJAVA.Room;

import java.io.File;

class RoomBarAdapter extends ArrayAdapter<Room> {

    private RoomBarAdapter(@NonNull Context context, Room[]  rooms) {
        super(context, R.layout.custom_roombar ,rooms);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater roomInflater =LayoutInflater.from(getContext());
        View roomView = roomInflater.inflate(R.layout.custom_roombar, parent, false);

        //references
        Room singleRoom = getItem(position);
        TextView roomNameTV = (TextView)roomView.findViewById(R.id.roomNameTextView);
        ImageView roomIcon = (ImageView) roomView.findViewById(R.id.roomIcon);

        roomIcon.setImageURI( Uri.fromFile( new File( singleRoom.getRoom_icon())));
        roomNameTV.setText(singleRoom.getName());

        //SelectingActivity.RoomBarHolder room = getItem(position);

        return roomView;
    }
}
