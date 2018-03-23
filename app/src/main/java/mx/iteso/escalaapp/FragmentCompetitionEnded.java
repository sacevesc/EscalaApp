package mx.iteso.escalaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.iteso.escalaapp.beans.CompetitionEnded;

/**
 * Created by aceve on 12/03/2018.
 */

public class FragmentCompetitionEnded extends Fragment {
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentCompetitionEnded() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_competition_ended, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<CompetitionEnded> compsEnded = new ArrayList<>();
        //String comp_name, String gym, String description, int photo, int participants, String date
        compsEnded.add(new CompetitionEnded("Estatal Ruta", "Ameyalli", "proxima compe de jalisco en ruta", 0, "24", "25-04-2017"));
        compsEnded.add(new CompetitionEnded("Summer Jam", "Bloce", "JAMMMM", 1, "67", "10-07-2017"));
        compsEnded.add(new CompetitionEnded("2do Aniversario ", "Motion Boulder", "1er aniversario de motion", 2, "120", "02-08-2017"));
        compsEnded.add(new CompetitionEnded("3do Aniversario ", "Motion", "1er aniversario de motion", 1, "12", "02-02-2017"));
        compsEnded.add(new CompetitionEnded("2do maratón ", "Ameyali", "1er aniversario de motion", 0, "139", "02-01-2017"));

        AdapterCompetitionEnded adapterCompetitionEnded = new AdapterCompetitionEnded(compsEnded);
        recyclerView.setAdapter(adapterCompetitionEnded);
        return view;
    }
}
