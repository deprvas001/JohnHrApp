package com.development.johnhrapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.development.johnhrapp.R;
import com.development.johnhrapp.adapter.OfferedJobAdapter;
import com.development.johnhrapp.adapter.UpcomingShiftAdapter;
import com.development.johnhrapp.databinding.FragmentHomeBinding;
import com.development.johnhrapp.model.UpcomingShift;
import com.development.johnhrapp.view.HomeScreen;
import com.development.johnhrapp.view.MyStats;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {
    List<UpcomingShift>  shiftList = new ArrayList<>();
    List<UpcomingShift>  offerJobList = new ArrayList<>();
    private UpcomingShiftAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    private OfferedJobAdapter offeredJobAdapter;
    FragmentHomeBinding fragmentHomeBinding;
    View view;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false);
        view = fragmentHomeBinding.getRoot();
        setClickListener();
        setReyclerView();
        upcomingJobShift();
        offeredJob();
        return view;
    }

    private void upcomingJobShift(){
        UpcomingShift shift = new UpcomingShift("Salesperson","$2000","09/10/2010","257 Chapel DriveFresh Meadows, NY 11365");
        shiftList.add(shift);

        shift = new UpcomingShift("Salesperson","$2000","09/10/2010","257 Chapel DriveFresh Meadows, NY 11365");
        shiftList.add(shift);

        mAdapter.notifyDataSetChanged();

    }

    private void setReyclerView(){
        ((HomeScreen)getActivity()).activityHomeScreenBinding.toolbarText.setText(getString(R.string.home));
        mAdapter = new UpcomingShiftAdapter(getActivity(),shiftList);
         mLayoutManager = new LinearLayoutManager(getActivity());
        fragmentHomeBinding.recyclerView.setLayoutManager(mLayoutManager);
        fragmentHomeBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        fragmentHomeBinding.recyclerView.setAdapter(mAdapter);

        offeredJobAdapter= new OfferedJobAdapter(getActivity(),offerJobList);
         mLayoutManager = new LinearLayoutManager(getActivity());
        fragmentHomeBinding.recyclerView1.setLayoutManager(mLayoutManager);
        fragmentHomeBinding.recyclerView1.setItemAnimator(new DefaultItemAnimator());
        fragmentHomeBinding.recyclerView1.setAdapter(offeredJobAdapter);
    }

    private void offeredJob(){
        UpcomingShift shift = new UpcomingShift("Salesperson","$2000","09/10/2010","257 Chapel DriveFresh Meadows, NY 11365");
        offerJobList.add(shift);

        shift = new UpcomingShift("Salesperson","$2000","09/10/2010","257 Chapel DriveFresh Meadows, NY 11365");
        offerJobList.add(shift);

        offeredJobAdapter.notifyDataSetChanged();
    }


    private void setClickListener(){
        fragmentHomeBinding.weekUpdate.viewStats.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.view_stats:
                startActivity(new Intent(getActivity(), MyStats.class));
                break;
        }
    }
}
