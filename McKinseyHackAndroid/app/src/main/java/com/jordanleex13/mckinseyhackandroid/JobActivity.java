package com.jordanleex13.mckinseyhackandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.jordanleex13.mckinseyhackandroid.Helpers.FragmentHelper;

public class JobActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        Toolbar toolBar = (Toolbar) findViewById(R.id.activity_job_toolbar);

        if (toolBar != null) {
            toolBar.setTitle("Jobs");
            toolBar.setTitleTextColor(getResources().getColor(R.color.white));
            setSupportActionBar(toolBar);

        }
        Log.e("HERE", "LOADED");

        JobsFragment newFragment = JobsFragment.newInstance();
        FragmentHelper.swapFragments(getSupportFragmentManager(), R.id.activity_job_container,
                newFragment, true, false, null, JobsFragment.TAG);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
