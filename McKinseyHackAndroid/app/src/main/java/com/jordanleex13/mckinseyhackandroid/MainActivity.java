package com.jordanleex13.mckinseyhackandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jordanleex13.mckinseyhackandroid.Helpers.FragmentHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolBar = (Toolbar) findViewById(R.id.activity_main_toolbar);

        if (toolBar != null) {
            toolBar.setTitle("Refugee Resources");
            toolBar.setTitleTextColor(getResources().getColor(R.color.white));
            setSupportActionBar(toolBar);

        }
        MainFragment newFragment = MainFragment.newInstance();
        FragmentHelper.swapFragments(getSupportFragmentManager(), R.id.activity_main_container,
                newFragment, true, false, null, MainFragment.TAG);
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
