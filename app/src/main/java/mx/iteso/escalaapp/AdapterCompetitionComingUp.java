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

import mx.iteso.escalaapp.beans.Competition;

/**
 * Created by aceve on 12/03/2018.
 */

public class AdapterCompetitionComingUp extends RecyclerView.Adapter<AdapterCompetitionComingUp.ViewHolder> {

    ArrayList<Competition> compComingUp;

    public AdapterCompetitionComingUp(ArrayList<Competition> compComingUp) {
        this.compComingUp = compComingUp;
    }

    public AdapterCompetitionComingUp.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_competition_comingup, parent, false);
        AdapterCompetitionComingUp.ViewHolder vh = new AdapterCompetitionComingUp.ViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(AdapterCompetitionComingUp.ViewHolder holder, final int position) {
        holder.mCompName.setText(compComingUp.get(position).getComp_name());
        holder.mGym.setText(compComingUp.get(position).getGym());
        holder.mParticipants.setText(compComingUp.get(position).getParticipants());
        holder.mDate.setText(compComingUp.get(position).getDate());

        switch (compComingUp.get(position).getImage()) {
            case 0:
                holder.mImage.setImageResource(R.drawable.ameyalli);
                break;
            case 1:
                holder.mImage.setImageResource(R.drawable.bloce);
                break;
            case 2:
                holder.mImage.setImageResource(R.drawable.motion);
                break;
            default:
                holder.mImage.setImageResource(R.drawable.ameyalli);
                break;
        }

        holder.mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityCompetition.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return compComingUp.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mCompName;
        public TextView mGym;
        public TextView mDate;
        public TextView mParticipants;
        public ImageView mImage;
        public RelativeLayout mDetail;

        public ViewHolder(View v) {
            super(v);
            mCompName = v.findViewById(R.id.item_comp_comingup_name);
            mGym = v.findViewById(R.id.item_comp_comingup_gym);
            mParticipants = v.findViewById(R.id.item_comp_comingup_entrants);
            mDetail = v.findViewById(R.id.item_comingup_relative);
            mImage = v.findViewById(R.id.item_gym_profile_picture);
            mDate = v.findViewById(R.id.item_comp_comingup_date);
        }
    }
}
