package com.development.johnhrapp.view.fragment;


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
import com.development.johnhrapp.adapter.ViewOfferJobAdapter;
import com.development.johnhrapp.databinding.OfferJobLayoutBinding;
import com.development.johnhrapp.model.UpcomingShift;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfferJobFragment extends Fragment {
OfferJobLayoutBinding layoutBinding;
View view;
    RecyclerView.LayoutManager mLayoutManager;
ViewOfferJobAdapter jobAdapter;
    List<UpcomingShift> shiftList = new ArrayList<>();

    public OfferJobFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layoutBinding = DataBindingUtil.inflate(inflater,R.layout.offer_job_layout, container, false);
        view = layoutBinding.getRoot();
        setReyclerView();
        upcomingJobShift();
        return view;
    }

    private void setReyclerView(){
        jobAdapter = new ViewOfferJobAdapter(getActivity(),shiftList);
        mLayoutManager = new LinearLayoutManager(getActivity());
        layoutBinding.recyclerView.setLayoutManager(mLayoutManager);
        layoutBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        layoutBinding.recyclerView.setAdapter(jobAdapter);
    }

    private void upcomingJobShift(){
        shiftList.clear();
        for(int i=0;i<6;i++){
            UpcomingShift shift = new UpcomingShift("Salesperson","$2000","09/10/2010","257 Chapel DriveFresh Meadows, NY 11365");
            shiftList.add(shift);
        }
        jobAdapter.notifyDataSetChanged();

    }
}
