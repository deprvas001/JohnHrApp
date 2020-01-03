package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityMyStatsBinding;

public class MyStats extends AppCompatActivity implements View.OnClickListener , RadioGroup.OnCheckedChangeListener {
ActivityMyStatsBinding statsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statsBinding = DataBindingUtil.setContentView(this,R.layout.activity_my_stats);
        setClickListener();
    }

    private void setClickListener(){
        statsBinding.back.setOnClickListener(this);
        statsBinding.menu.setOnClickListener(this);
        statsBinding.monthGroup.setOnCheckedChangeListener(this);
        statsBinding.monthGroupSec.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;

            case R.id.menu:
                startActivity(new Intent(this,NotificationScreen.class));
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int id) {
        switch (id){
            case R.id.month_one:
                startActivity(new Intent(this,MonthlyReport.class));
                break;

            case R.id.month_two:
                startActivity(new Intent(this,MonthlyReport.class));
                break;

            case R.id.month_three:
                startActivity(new Intent(this,MonthlyReport.class));
                break;

            case R.id.month_four:
                startActivity(new Intent(this,MonthlyReport.class));
                break;

        }
    }
}
