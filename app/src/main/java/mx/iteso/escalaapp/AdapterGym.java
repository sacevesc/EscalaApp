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

import mx.iteso.escalaapp.beans.Gym;

/**
 * Created by aceve on 03/03/2018.
 */


public class AdapterGym extends RecyclerView.Adapter<AdapterGym.ViewHolder> {

    ArrayList<Gym> gyms;

    public AdapterGym(ArrayList<Gym> gyms) {
        this.gyms = gyms;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_gym, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mName.setText(gyms.get(position).getName());
        holder.mCity.setText(gyms.get(position).getCity());
        holder.mImage.setImageDrawable(gyms.get(position).getPhoto());
        holder.mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(),ActivityGym.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return gyms.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public TextView mCity;
        public ImageView mImage;
        public RelativeLayout mDetail;

        public ViewHolder(View v) {
            super(v);
            mName = v.findViewById(R.id.item_gym_name);
            mCity = v.findViewById(R.id.item_gym_city);
            mImage = v.findViewById(R.id.item_gym_profile_picture);
            mDetail = v.findViewById(R.id.item_gym_relative);
        }
    }

}


