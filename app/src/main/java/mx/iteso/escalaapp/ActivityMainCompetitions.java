package mx.iteso.escalaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by aceve on 04/03/2018.
 */

public class ActivityMainCompetitions extends AppCompatActivity {
    Button gyms, comps, climbers;
    private FragmentCompetitionEnded fragmentCompetitionEnded;
    private FragmentCompetitionComingUp fragmentCompetitionComingUp;
    private FragmentCompetitionLive fragmentCompetitionLive;

    private RecyclerView.LayoutManager mLayoutManager;
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_competitions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        ImageView imageView = findViewById(R.id.activity_main_profile);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMainCompetitions.this, ActivityClimber.class);
                startActivity(intent);
            }
        });
        gyms = findViewById(R.id.main_gyms_button);
        gyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMainCompetitions.this, ActivityMainGyms.class);
                startActivity(intent);
            }
        });
        comps = findViewById(R.id.main_comps_button);
        comps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        climbers = findViewById(R.id.main_climbers_button);
        climbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMainCompetitions.this, ActivityMainClimbers.class);
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

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private FragmentManager fm;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm;
        }


        @Override
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
                return fragmentCompetitionComingUp;
            case 3:
            case 4:
            default:
                return new FragmentCompetitionLive();
        }
    }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.competitions_ended);
                case 1:
                    return getString(R.string.competitions_live);
                case 2:
                    return getString(R.string.competitions_comingup);
            }
            return null;
        }
    }

}
