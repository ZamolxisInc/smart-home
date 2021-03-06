package org.zamolxis.smarthome;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {



    private Context mContext ;
    private List<Room> mData ;


    public RecyclerViewAdapter(Context mContext, List<Room> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate cardview
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_room,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //set the holder
        holder.roomName.setText(mData.get(position).getName());
        holder.imageName.setImageURI(mData.get(position).getImagePathUri());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,RoomQuickAdd.class);

                // passing data to the room activity
                intent.putExtra("Title",mData.get(position).getName());
                intent.putExtra("Thumbnail",mData.get(position).getImagePath());
                // start the activity
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView roomName;
        ImageView imageName;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            roomName = (TextView) itemView.findViewById(R.id.room_name_id) ;
            imageName = (ImageView) itemView.findViewById(R.id.room_image_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }

}
