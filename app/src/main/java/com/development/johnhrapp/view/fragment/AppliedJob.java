package com.development.johnhrapp.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.development.johnhrapp.R;
import com.development.johnhrapp.adapter.AppliedJobAdapter;
import com.development.johnhrapp.adapter.OfferedJobAdapter;
import com.development.johnhrapp.adapter.UpcomingShiftAdapter;
import com.development.johnhrapp.databinding.FragmentAppliedJobBinding;
import com.development.johnhrapp.databinding.FragmentMyJobsBinding;
import com.development.johnhrapp.model.UpcomingShift;

import java.util.ArrayList;
import java.util.List;

public class AppliedJob extends Fragment {
    FragmentAppliedJobBinding jobBinding;
    List<UpcomingShift> shiftList = new ArrayList<>();
    private AppliedJobAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    private OfferedJobAdapter offeredJobAdapter;
    View view;
    public AppliedJob() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        jobBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_applied_job, container, false);
        view = jobBinding.getRoot();
        setReyclerView();
        upcomingJobShift();
        return view;
    }

    private void setReyclerView(){
        mAdapter = new AppliedJobAdapter(getActivity(),shiftList);
        mLayoutManager = new LinearLayoutManager(getActivity());
        jobBinding.recyclerView.setLayoutManager(mLayoutManager);
        jobBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        jobBinding.recyclerView.setAdapter(mAdapter);
    }

    private void upcomingJobShift(){
        shiftList.clear();
        for(int i=0;i<6;i++){
            UpcomingShift shift = new UpcomingShift("Salesperson","$2000","09/10/2010","257 Chapel DriveFresh Meadows, NY 11365");
            shiftList.add(shift);
        }
        mAdapter.notifyDataSetChanged();

    }

}
