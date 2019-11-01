package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivitySettingScreenBinding;

public class SettingScreen extends AppCompatActivity implements View.OnClickListener {
ActivitySettingScreenBinding settingScreenBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingScreenBinding = DataBindingUtil.setContentView(this,R.layout.activity_setting_screen);
        setOnClickListener();
    }

    private  void setOnClickListener(){
        settingScreenBinding.back.setOnClickListener(this);
        settingScreenBinding.changePassowrd.setOnClickListener(this);
        settingScreenBinding.help.setOnClickListener(this);
        settingScreenBinding.hiddenJob.setOnClickListener(this);
        settingScreenBinding.faq.setOnClickListener(this);
        settingScreenBinding.editProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;

            case R.id.change_passowrd:
                startActivity(new Intent(this,ChangePassword.class));
                break;

            case R.id.help:
                startActivity(new Intent(this,Help.class));
                break;

            case R.id.hidden_job:
                startActivity(new Intent(this,HiddenJobs.class));
                break;

            case R.id.faq:
                startActivity(new Intent(this,FaqScreen.class));
                break;

            case R.id.edit_profile:
                startActivity(new Intent(this,EditProfile.class));
                break;


        }
    }
}
