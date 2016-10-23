package com.jordanleex13.mckinseyhackandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.jordanleex13.mckinseyhackandroid.Helpers.FragmentHelper;


public class JobsMapFragment extends Fragment implements OnMapReadyCallback {


    private GoogleMap mMap;
    public JobsMapFragment() {
        // Required empty public constructor
    }

    public static JobsMapFragment newInstance() {
        JobsMapFragment fragment = new JobsMapFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_jobs_map, container, false);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        FragmentHelper.swapFragments(getChildFragmentManager(), R.id.fragment_jobs_map_container,
                mapFragment, true, false, null, null );

        mapFragment.getMapAsync(this);

        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}
