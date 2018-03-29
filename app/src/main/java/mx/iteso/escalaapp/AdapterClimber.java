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

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_climber, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mFirstName.setText(climbers.get(position).getFirstname());
        holder.mLastName.setText(climbers.get(position).getLastname());
        holder.mGym.setText(climbers.get(position).getGym());

        switch (climbers.get(position).getPhoto()) {
            case 0:
                holder.mImage.setImageResource(R.drawable.arturo_perfil);
                break;
            case 1:
                holder.mImage.setImageResource(R.drawable.ger_perfil);
                break;
            case 2:
                holder.mImage.setImageResource(R.drawable.keko_perfil);
                break;
            case 3:
                holder.mImage.setImageResource(R.drawable.luis_perfil);
                break;
            case 4:
                holder.mImage.setImageResource(R.drawable.sebas_perfil);
                break;
            default:
                holder.mImage.setImageResource(R.drawable.keko_perfil);
                break;
        }


        holder.mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityClimber.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return climbers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mFirstName;
        public TextView mLastName;
        public TextView mGym;
        public ImageView mImage;
        public RelativeLayout mDetail;

        public ViewHolder(View v) {
            super(v);
            mFirstName = v.findViewById(R.id.item_climber_firstname);
            mLastName = v.findViewById(R.id.item_climber_lastname);
            mImage = v.findViewById(R.id.item_climber_profile_picture);
            mGym = v.findViewById(R.id.item_climber_gym);
            mDetail = v.findViewById(R.id.item_climber_relative);
        }
    }

}


