package mx.iteso.escalaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.iteso.escalaapp.beans.Competition;

/**
 * Created by aceve on 12/03/2018.
 */

public class FragmentCompetitionComingUp extends Fragment {
    private RecyclerView.LayoutManager mLayoutManager;
    private AdapterCompetitionComingUp adapterCompetitionComingUp;

    public FragmentCompetitionComingUp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_competition_comingup, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Competition> compsComingUp = new ArrayList<>();
        //String comp_name, String gym, String description, int photo, int participants, String date
        compsComingUp.add(new Competition("2do Aniversario ", "Motion Boulder", "7mo aniversario de motion", 2, "120", "02-08-2019"));
        compsComingUp.add(new Competition("3do Aniversario ", "Motion", "8vo aniversario de motion", 2, "12", "02-02-2019"));
        compsComingUp.add(new Competition("2do maratón ", "Ameyali", "9no aniversario de ameyalli", 2, "139", "02-01-2020"));
        compsComingUp.add(new Competition("Estatal Ruta", "Ameyalli", "proxima compe de jalisco en ruta", 2, "24", "25-04-2021"));
        compsComingUp.add(new Competition("Summer Jam", "Bloce", "JAMMMM", 2, "67", "10-07-2017"));


        adapterCompetitionComingUp = new AdapterCompetitionComingUp(compsComingUp);
        recyclerView.setAdapter(adapterCompetitionComingUp);
        return view;
    }

    public AdapterCompetitionComingUp getAdapter() {
        return this.adapterCompetitionComingUp;
    }
}
