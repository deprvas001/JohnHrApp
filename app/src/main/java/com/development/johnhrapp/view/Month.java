package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityMonthBinding;

public class Month extends AppCompatActivity implements View.OnClickListener {
ActivityMonthBinding monthBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        monthBinding = DataBindingUtil.setContentView(this,R.layout.activity_month);
        setClickListener();
    }

    private void setClickListener(){
        monthBinding.back.setOnClickListener(this);
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
