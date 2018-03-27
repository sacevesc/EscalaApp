package mx.iteso.escalaapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.iteso.escalaapp.beans.Climber;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentClimbers extends Fragment {
    private RecyclerView.LayoutManager mLayoutManager;
    public FragmentClimbers() {
        // Required empty public constructor
    }

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

        ArrayList<Climber> climbers = new ArrayList<>();
        climbers.add(new Climber("Arturo", "Garcia", "Mantis", 0));
        climbers.add(new Climber("German", "Sanchez", "", 1));
        climbers.add(new Climber("Edric", "Freyria", "Motion Boulder", 2));
        climbers.add(new Climber("Luis", "Vazquez", "", 3));
        climbers.add(new Climber("Sebastián", "Aceves", "Rocodromo Ameyalli", 4));

        climbers.add(new Climber("Arturo", "Garcia", "Mantis", 0));
        climbers.add(new Climber("German", "Sanchez", "", 1));
        climbers.add(new Climber("Edric", "Freyria", "Motion Boulder", 2));
        climbers.add(new Climber("Luis", "Vazquez", "", 3));
        climbers.add(new Climber("Sebastián", "Aceves", "Rocodromo Ameyalli", 4));
        climbers.add(new Climber("Arturo", "Garcia", "Mantis", 0));
        AdapterClimber adapterClimber = new AdapterClimber(climbers);
        recyclerView.setAdapter(adapterClimber);
        return view;
    }
}
