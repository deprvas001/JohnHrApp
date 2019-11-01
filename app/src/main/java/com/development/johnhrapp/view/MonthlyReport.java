package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityMonthlyReportBinding;

public class MonthlyReport extends AppCompatActivity implements View.OnClickListener {
ActivityMonthlyReportBinding reportBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reportBinding = DataBindingUtil.setContentView(this,R.layout.activity_monthly_report);
        setClickListener();
    }

    private void setClickListener(){
        reportBinding.back.setOnClickListener(this);
        reportBinding.details.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;

            case R.id.details:
                startActivity(new Intent(this,Month.class));
                break;

                
        }
    }
}
