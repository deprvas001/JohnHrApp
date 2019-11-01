package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.adapter.UpcomingShiftAdapter;
import com.development.johnhrapp.databinding.ActivityHiddenJobsBinding;
import com.development.johnhrapp.model.UpcomingShift;

import java.util.ArrayList;
import java.util.List;

public class HiddenJobs extends AppCompatActivity implements View.OnClickListener {
ActivityHiddenJobsBinding hiddenJobsBinding;
    List<UpcomingShift> shiftList = new ArrayList<>();
    private UpcomingShiftAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hiddenJobsBinding = DataBindingUtil.setContentView(this,R.layout.activity_hidden_jobs);
        setClickListener();
        setReyclerView();
        upcomingJobShift();
    }

    private void setClickListener(){
        hiddenJobsBinding.back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }

    private void setReyclerView(){
        mAdapter = new UpcomingShiftAdapter(this,shiftList);
        mLayoutManager = new LinearLayoutManager(HiddenJobs.this);
        hiddenJobsBinding.recyclerView.setLayoutManager(mLayoutManager);
        hiddenJobsBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        hiddenJobsBinding.recyclerView.setAdapter(mAdapter);
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
