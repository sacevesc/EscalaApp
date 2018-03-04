package mx.iteso.escalaapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import mx.iteso.escalaapp.beans.ItemCompetition;

/**
 * Created by aceve on 03/03/2018.
 */


public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

    ArrayList<ItemCompetition> products;
    public AdapterProduct(ArrayList<ItemCompetition> products) {
        this.products = products;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public TextView mStore;
        public TextView mPhone;
        public TextView mAddress;
        public ImageView mImage;
        public ImageView mImageStore;
        public Button mDetail;

        public ViewHolder(View v) {
            super(v);
            mTitle = v.findViewById(R.id.item_product_title);
            mStore = v.findViewById(R.id.item_product_store);
            mPhone = (TextView) v.findViewById(R.id.item_product_phone);
            mAddress = v.findViewById(R.id.item_product_location);
            mImage = v.findViewById(R.id.item_product_image);
            mImageStore = v.findViewById(R.id.item_product_thumbnail);
            mDetail = v.findViewById(R.id.item_product_detail);
        }
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_competition, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTitle.setText(products.get(position).getTitle());
        holder.mStore.setText(products.get(position).getStore());
        holder.mPhone.setText(products.get(position).getPhone());
        holder.mPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + products.get(position).getPhone()));
                v.getContext().startActivity(intent);
            }
        });
        holder.mAddress.setText(products.get(position).getAddress());
        holder.mImage.setImageDrawable(products.get(position).getPhoto());
        holder.mImageStore.setImageDrawable(products.get(position).getStore_photo());
        holder.mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), products.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int getItemCount() {
        return products.size();
    }
}


