package mx.iteso.escalaapp;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import mx.iteso.escalaapp.beans.Climber;

/**
 * Created by aceve on 03/03/2018.
 */


public class AdapterClimber extends RecyclerView.Adapter<AdapterClimber.ViewHolder> {

    ArrayList<Climber> climbers;
    public AdapterClimber(ArrayList<Climber> climbers) {
        this.climbers = climbers;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mFirstName;
        public TextView mLastName;
        public ImageView mImage;
        public RelativeLayout mDetail;

        public ViewHolder(View v) {
            super(v);
            mFirstName = v.findViewById(R.id.item_gym_name);
            mLastName =  v.findViewById(R.id.item_gym_city);
            mImage = v.findViewById(R.id.item_gym_profile_picture);
            mDetail = v.findViewById(R.id.item_gym_relative);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_gym, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mFirstName.setText(climbers.get(position).getFirstname());
        holder.mLastName.setText(climbers.get(position).getLastname());
        holder.mImage.setImageDrawable(climbers.get(position).getPhoto());
        holder.mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(),ActivityGym.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return climbers.size();
    }

}


