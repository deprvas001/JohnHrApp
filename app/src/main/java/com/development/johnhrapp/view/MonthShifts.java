package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.adapter.MonthlyShiftAdapter;
import com.development.johnhrapp.adapter.UpcomingShiftAdapter;
import com.development.johnhrapp.databinding.ActivityMonthShiftsBinding;
import com.development.johnhrapp.model.MonthlyShift;
import com.development.johnhrapp.model.UpcomingShift;

import java.util.ArrayList;
import java.util.List;

public class MonthShifts extends AppCompatActivity implements View.OnClickListener {
ActivityMonthShiftsBinding monthShiftsBinding;
    List<MonthlyShift> shiftList = new ArrayList<>();
    private MonthlyShiftAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        monthShiftsBinding = DataBindingUtil.setContentView(this,R.layout.activity_month_shifts);
        setClickListener();
        setReyclerView();
        upcomingJobShift();
    }

    private void setClickListener(){
        monthShiftsBinding.back.setOnClickListener(this);
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
        mAdapter = new MonthlyShiftAdapter(shiftList);
        mLayoutManager = new LinearLayoutManager(MonthShifts.this);
        monthShiftsBinding.recyclerView.setLayoutManager(mLayoutManager);
        monthShiftsBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        monthShiftsBinding.recyclerView.setAdapter(mAdapter);
    }

    private void upcomingJobShift(){
        shiftList.clear();
        for(int i=0;i<6;i++){
            MonthlyShift shift = new MonthlyShift("Salesperson","$2000","09/10/2010","257 Chapel DriveFresh Meadows, NY 11365");
            shiftList.add(shift);
        }
        mAdapter.notifyDataSetChanged();

    }
}
