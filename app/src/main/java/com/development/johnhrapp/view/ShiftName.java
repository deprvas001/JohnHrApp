package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityShiftNameBinding;

public class ShiftName extends AppCompatActivity implements View.OnClickListener {
ActivityShiftNameBinding shiftNameBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shiftNameBinding = DataBindingUtil.setContentView(this,R.layout.activity_shift_name);
        setClickListener();
    }
    private void setClickListener(){
        shiftNameBinding.back.setOnClickListener(this);
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
