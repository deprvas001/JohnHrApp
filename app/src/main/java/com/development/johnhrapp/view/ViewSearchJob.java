package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityViewSearchJobBinding;

public class ViewSearchJob extends AppCompatActivity implements View.OnClickListener {
ActivityViewSearchJobBinding jobBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jobBinding = DataBindingUtil.setContentView(this,R.layout.activity_view_search_job);
        setClickListener();
    }

    private void setClickListener(){
        jobBinding.back.setOnClickListener(this);
        jobBinding.btnApply.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;

            case R.id.btn_apply:
                startActivity(new Intent(this,ApplyJob.class));
                break;
        }
    }
}
