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
import com.development.johnhrapp.adapter.UpcomingShiftAdapter;
import com.development.johnhrapp.databinding.FragmentSearchJobBinding;
import com.development.johnhrapp.model.UpcomingShift;
import com.development.johnhrapp.view.HomeScreen;

import java.util.ArrayList;
import java.util.List;


public class SearchJob extends Fragment {
FragmentSearchJobBinding searchJobBinding;
View view;
    List<UpcomingShift> shiftList = new ArrayList<>();
    private UpcomingShiftAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    public SearchJob() {
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
        searchJobBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_search_job, container, false);
        view = searchJobBinding.getRoot();
        initializeView();
        setReyclerView();
        upcomingJobShift();
        return view;
    }

    private void initializeView(){
        ((HomeScreen)getActivity()).activityHomeScreenBinding.toolbarText.setText(getString(R.string.search_job));
    }

    private void setReyclerView(){
        mAdapter = new UpcomingShiftAdapter(getActivity(),shiftList);
        mLayoutManager = new LinearLayoutManager(getActivity());
        searchJobBinding.recyclerView.setLayoutManager(mLayoutManager);
        searchJobBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        searchJobBinding.recyclerView.setAdapter(mAdapter);
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
