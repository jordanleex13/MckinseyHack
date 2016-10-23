package com.jordanleex13.mckinseyhackandroid;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.jordanleex13.mckinseyhackandroid.Helpers.FragmentHelper;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener{


    public static final String TAG = MainFragment.class.getSimpleName();

    public MainFragment() {
        // Required empty public constructor
    }


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_main, container, false);

        ImageButton educationButton = (ImageButton) v.findViewById(R.id.fragment_main_education_logo);
        educationButton.setBackgroundColor(getResources().getColor(R.color.white));
        educationButton.setOnClickListener(this);

        ImageButton jobsButton = (ImageButton) v.findViewById(R.id.fragment_main_jobs_logo);
        jobsButton.setBackgroundColor(getResources().getColor(R.color.white));
        jobsButton.setOnClickListener(this);

        ImageButton religionButton = (ImageButton) v.findViewById(R.id.fragment_main_religion_logo);
        religionButton.setBackgroundColor(getResources().getColor(R.color.white));
        religionButton.setOnClickListener(this);

        ImageButton communityButton = (ImageButton) v.findViewById(R.id.fragment_main_community_logo);
        communityButton.setBackgroundColor(getResources().getColor(R.color.white));
        communityButton.setOnClickListener(this);

        ImageButton policeButton = (ImageButton) v.findViewById(R.id.fragment_main_police_logo);
        policeButton.setBackgroundColor(getResources().getColor(R.color.white));
        policeButton.setOnClickListener(this);

        ImageButton prAppButton = (ImageButton) v.findViewById(R.id.fragment_main_prapp_logo);
        prAppButton.setBackgroundColor(getResources().getColor(R.color.white));
        prAppButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentHelper.setUpActionBar(getActivity(), true, "Categories");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.fragment_main_jobs_logo:
                JobsFragment newFragment = JobsFragment.newInstance();
                FragmentHelper.swapFragments(getActivity().getSupportFragmentManager(), R.id.activity_main_container,
                        newFragment, false, true, null, JobsFragment.TAG);
                break;


            default:
                Log.e(TAG, "Unknown click registered with ID : " + String.valueOf(v.getId()));
                break;
        }
    }
}
