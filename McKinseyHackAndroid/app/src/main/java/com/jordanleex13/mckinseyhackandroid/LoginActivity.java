package com.jordanleex13.mckinseyhackandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.jordanleex13.mckinseyhackandroid.Helpers.ParseJobsTask;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolBar = (Toolbar) findViewById(R.id.activity_login_toolbar);

        if (toolBar != null) {
            toolBar.setTitle("Refugee Resources");
            toolBar.setTitleTextColor(getResources().getColor(R.color.white));
            setSupportActionBar(toolBar);

        }

        new ParseJobsTask().execute();

        final Context mContext = this;
        Button button = (Button) findViewById(R.id.activity_login_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);

            }
        });
    }


}
