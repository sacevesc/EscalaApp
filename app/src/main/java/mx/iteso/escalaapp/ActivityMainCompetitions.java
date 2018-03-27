package mx.iteso.escalaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import mx.iteso.escalaapp.beans.Competition;

/**
 * Created by aceve on 04/03/2018.
 */

public class ActivityMainCompetitions extends Fragment {
    protected RecyclerView recyclerView;
    Button ended, live, comingup;
    private FragmentCompetitionEnded fragmentCompetitionEnded;
    private FragmentCompetitionComingUp fragmentCompetitionComingUp;
    private FragmentCompetitionLive fragmentCompetitionLive;
    private View view;
    private RecyclerView.LayoutManager mLayoutManager;
    private ViewPager mViewPager;

    public ActivityMainCompetitions() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_main_competitions, container, false);

        recyclerView = view.findViewById(R.id.fragment_recycler_view);
        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ended = view.findViewById(R.id.fragment_ended_button);
        live = view.findViewById(R.id.fragment_live_button);
        comingup = view.findViewById(R.id.fragment_comingup_button);

        ended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchEnded();
            }
        });
        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchLive();
            }
        });
        comingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchComingUp();
            }
        });
        switchLive();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        switch (position) {
            case 0:
                if (fragmentCompetitionEnded == null)
                    fragmentCompetitionEnded = new FragmentCompetitionEnded();
                return fragmentCompetitionEnded;

            case 1:
                if (fragmentCompetitionLive == null)
                    fragmentCompetitionLive = new FragmentCompetitionLive();
                return fragmentCompetitionLive;

            case 2:
                if (fragmentCompetitionComingUp == null)
                    fragmentCompetitionComingUp = new FragmentCompetitionComingUp();
                return fragmentCompetitionLive;
            default:
                return new FragmentCompetitionLive();
        }
    }

    public FragmentCompetitionLive getItemLive() {
        if (fragmentCompetitionLive == null)
            fragmentCompetitionLive = new FragmentCompetitionLive();
        return fragmentCompetitionLive;
    }

    public void switchEnded() {
        getItem(0);

        AdapterCompetitionEnded adapterCompetitionEnded = fragmentCompetitionEnded.getAdapter();
        recyclerView.setAdapter(adapterCompetitionEnded);
        ended.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        live.setTextColor(getResources().getColor(R.color.colorPrimary));
        comingup.setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    public void switchLive() {
        ArrayList<Competition> arrayList = getItemLive().getArrayCompetitions();
        AdapterCompetitionLive adapterCompetitionLive = new AdapterCompetitionLive(arrayList);
        recyclerView.setAdapter(adapterCompetitionLive);
        ended.setTextColor(getResources().getColor(R.color.colorPrimary));
        live.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        comingup.setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    public void switchComingUp() {
        getItem(2);
        AdapterCompetitionComingUp adapterCompetitionComingUp = fragmentCompetitionComingUp.getAdapter();
        recyclerView.setAdapter(adapterCompetitionComingUp);
        ended.setTextColor(getResources().getColor(R.color.colorPrimary));
        live.setTextColor(getResources().getColor(R.color.colorPrimary));
        comingup.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
    }


}
