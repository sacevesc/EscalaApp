package mx.iteso.escalaapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import mx.iteso.escalaapp.beans.Gym;


public class ActivityMainGyms extends AppCompatActivity {

    Button gymsBtn, comps, climbersBtn;
    Context context = ActivityMainGyms.this;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gyms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        setSupportActionBar(toolbar);


        RecyclerView recyclerView = findViewById(R.id.fragment_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(ActivityMainGyms.this);
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Gym> gyms = new ArrayList<>();
        gyms.add(new Gym("Ameyalli", "Muro de escalada en Zapopan Jalisco.", "Guadalajara", getResources().getDrawable(R.drawable.ameyalli)));
        gyms.add(new Gym("Motion", "motiva motion un lugar para boulderear", "Zapopan", getResources().getDrawable(R.drawable.motion)));
        gyms.add(new Gym("Bloc-e", "Para ser el mejor, escala con los mejores", "CDMX", getResources().getDrawable(R.drawable.bloce)));

        AdapterGym adapterProduct = new AdapterGym(gyms);
        recyclerView.setAdapter(adapterProduct);


        gymsBtn = findViewById(R.id.main_gyms_button);
        gymsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                Intent intent = new Intent(context, ActivityMainClimbers.class);
                startActivity(intent);
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
