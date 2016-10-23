package com.jordanleex13.mckinseyhackandroid;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.jordanleex13.mckinseyhackandroid.Helpers.FragmentHelper;
import com.jordanleex13.mckinseyhackandroid.Managers.JobManager;
import com.jordanleex13.mckinseyhackandroid.Models.Job;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JobsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobsFragment extends Fragment implements RVAdapterJobs.ViewHolder.OnJobClickedListener{

    public static final String TAG = JobsFragment.class.getSimpleName();

    private RecyclerView mRecyclerView;

    // Adapters
    private ArrayAdapter<String> mSpinnerAdapter;
    private RVAdapterJobs mRVAdapter;

    public JobsFragment() {
        // Required empty public constructor
    }


    public static JobsFragment newInstance() {
        JobsFragment fragment = new JobsFragment();
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
        View v = inflater.inflate(R.layout.fragment_jobs, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_jobs_recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRVAdapter = new RVAdapterJobs(JobManager.getList());
        mRVAdapter.setOnJobClickedListener(this);

        mRecyclerView.setAdapter(mRVAdapter);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentHelper.setUpActionBar(getActivity(), true, "Jobs");
    }

    @Override
    public void onJobClicked(View itemView) {
        Log.e(TAG, "HERE");
        int position = mRecyclerView.getChildLayoutPosition(itemView);
        Job temp = JobManager.getJob(position);

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(temp.getUrl()));
        startActivity(browserIntent);

        Toast.makeText(getContext(), temp.getJobTitle(), Toast.LENGTH_SHORT).show();
    }
}
