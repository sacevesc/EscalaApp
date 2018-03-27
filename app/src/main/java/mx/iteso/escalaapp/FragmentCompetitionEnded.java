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

public class FragmentCompetitionEnded extends Fragment {
    private RecyclerView.LayoutManager mLayoutManager;
    private AdapterCompetitionEnded adapterCompetitionEnded;


    public FragmentCompetitionEnded() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gym, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Competition> compsEnded = new ArrayList<>();
        //String comp_name, String gym, String description, int photo, int participants, String date
        compsEnded.add(new Competition("Estatal Ruta", "Ameyalli", "proxima compe de jalisco en ruta", 0, "24", "25-04-2017"));
        compsEnded.add(new Competition("Summer Jam", "Bloce", "JAMMMM", 0, "67", "10-07-2017"));
        compsEnded.add(new Competition("2do Aniversario ", "Motion Boulder", "1er aniversario de motion", 0, "120", "02-08-2017"));
        compsEnded.add(new Competition("3do Aniversario ", "Motion", "1er aniversario de motion", 0, "12", "02-02-2017"));
        compsEnded.add(new Competition("2do maratón ", "Ameyali", "1er aniversario de motion", 0, "139", "02-01-2017"));

        adapterCompetitionEnded = new AdapterCompetitionEnded(compsEnded);
        recyclerView.setAdapter(adapterCompetitionEnded);
        return view;
    }

    public AdapterCompetitionEnded getAdapter() {
        return this.adapterCompetitionEnded;
    }


}
