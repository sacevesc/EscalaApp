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

public class FragmentCompetitionLive extends Fragment {
    protected ArrayList<Competition> compsLive;
    private RecyclerView.LayoutManager mLayoutManager;
    private AdapterCompetitionLive adapterCompetitionLive;

    public FragmentCompetitionLive() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_competition_live, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        compsLive = new ArrayList<>();
        //String comp_name, String gym, String description, int photo, int participants, String date
        compsLive.add(new Competition("2do Aniversario ", "Motion Boulder", "7mo aniversario de motion", 1, "120", "02-08-2019"));
        compsLive.add(new Competition("3do Aniversario ", "Motion", "8vo aniversario de motion", 1, "12", "02-02-2019"));
        compsLive.add(new Competition("2do maratón ", "Ameyali", "9no aniversario de ameyalli", 1, "139", "02-01-2020"));
        compsLive.add(new Competition("Estatal Ruta", "Ameyalli", "proxima compe de jalisco en ruta", 1, "24", "25-04-2021"));
        compsLive.add(new Competition("Summer Jam", "Bloce", "JAMMMM", 1, "67", "10-07-2017"));


        adapterCompetitionLive = new AdapterCompetitionLive(compsLive);
        recyclerView.setAdapter(adapterCompetitionLive);
        return view;
    }

    public AdapterCompetitionLive getAdapter() {
        return this.adapterCompetitionLive;
    }

    public ArrayList<Competition> getArrayCompetitions() {
        return compsLive;
    }
}
