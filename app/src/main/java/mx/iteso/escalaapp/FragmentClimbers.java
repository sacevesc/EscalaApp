package mx.iteso.escalaapp;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.iteso.escalaapp.beans.ItemCompetition;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentClimbers extends Fragment {


    public FragmentClimbers() {
        // Required empty public constructor
    }
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_climbers, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemCompetition> products = new ArrayList<>();
        products.add(new ItemCompetition("titulo",
                "Tienda","tel","dirccion",
                getResources().getDrawable(R.drawable.ic_launcher_background),
                getResources().getDrawable(R.drawable.ic_launcher_foreground)));


        AdapterProduct adapterProduct = new AdapterProduct(products);
        recyclerView.setAdapter(adapterProduct);
        return view;
    }
}
