package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityViewJobOneBinding;

public class ViewJobOne extends AppCompatActivity implements View.OnClickListener {
ActivityViewJobOneBinding oneBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        oneBinding = DataBindingUtil.setContentView(this,R.layout.activity_view_job_one);
        setClickListener();
    }

    private void setClickListener(){
        oneBinding.back.setOnClickListener(this);
        oneBinding.btnClock.setOnClickListener(this);
        oneBinding.clockShift.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.btn_clock:
                startActivity(new Intent(this,ClockIn.class));
                break;

            case R.id.clock_shift:
                startActivity(new Intent(this,CancelShift.class));
                break;
        }
    }
}
