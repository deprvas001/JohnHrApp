package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityAddHolidayBinding;

public class AddHoliday extends AppCompatActivity implements View.OnClickListener {
ActivityAddHolidayBinding holidayBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        holidayBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_holiday);
        setClickListener();
    }

    private void setClickListener(){
        holidayBinding.back.setOnClickListener(this);
        holidayBinding.menu.setOnClickListener(this);
        holidayBinding.btnSave.setOnClickListener(this);
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

            case R.id.btn_save:
                finish();
                break;
        }
    }
}
