package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.adapter.SearchJobAdapter;
import com.development.johnhrapp.adapter.UpcomingShiftAdapter;
import com.development.johnhrapp.databinding.ActivitySortingJobSearchBinding;
import com.development.johnhrapp.model.UpcomingShift;

import java.util.ArrayList;
import java.util.List;

public class SortingJobSearch extends AppCompatActivity implements View.OnClickListener {
ActivitySortingJobSearchBinding searchBinding;
    List<UpcomingShift> shiftList = new ArrayList<>();
    private SearchJobAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchBinding = DataBindingUtil.setContentView(this,R.layout.activity_sorting_job_search);
        setClickListener();
        setReyclerView();
        upcomingJobShift();
    }

    private void setClickListener(){
       searchBinding.back.setOnClickListener(this);
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
        mAdapter = new SearchJobAdapter(this,shiftList);
        mLayoutManager = new LinearLayoutManager(this);
        searchBinding.recyclerView.setLayoutManager(mLayoutManager);
        searchBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        searchBinding.recyclerView.setAdapter(mAdapter);
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
