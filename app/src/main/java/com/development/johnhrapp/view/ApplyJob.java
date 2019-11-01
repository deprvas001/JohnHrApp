package com.development.johnhrapp.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityApplyJobBinding;

public class ApplyJob extends AppCompatActivity implements View.OnClickListener {
ActivityApplyJobBinding jobBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jobBinding = DataBindingUtil.setContentView(this,R.layout.activity_apply_job);
        setClickListener();
    }

    private void setClickListener(){
        jobBinding.back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }


}
