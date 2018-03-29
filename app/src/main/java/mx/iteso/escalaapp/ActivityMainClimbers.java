package mx.iteso.escalaapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import mx.iteso.escalaapp.beans.Climber;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityMainClimbers extends AppCompatActivity {
    Button gyms, comps, climbersBtn;
    Context context = ActivityMainClimbers.this;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_climbers);
        RecyclerView recyclerView = findViewById(R.id.fragment_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        setSupportActionBar(toolbar);
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(ActivityMainClimbers.this);
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

        gyms = findViewById(R.id.main_gyms_button);
        gyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityMainGyms.class);
                startActivity(intent);
            }
        });
        comps = findViewById(R.id.main_comps_button);
        comps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityMainCompetitions.class);
                startActivity(intent);
            }
        });
        climbersBtn = findViewById(R.id.main_climbers_button);
        climbersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
