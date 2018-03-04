package mx.iteso.escalaapp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.iteso.escalaapp.beans.Gym;


public class FragmentGym extends android.support.v4.app.Fragment {

    public FragmentGym() {
    }

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gym, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);


        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

            ArrayList<Gym> gyms = new ArrayList<>();
        gyms.add(new Gym("Ameyalli","Muro de escalada en Zapopan Jalisco.", "Zapopan",getResources().getDrawable(R.drawable.ameyalli)));
        gyms.add(new Gym("Motion","motiva motion un lugar para boulderear", "Zapopan",getResources().getDrawable(R.drawable.motion)));

        AdapterProduct adapterProduct = new AdapterProduct(gyms);
        recyclerView.setAdapter(adapterProduct);
        return view;
    }
}
