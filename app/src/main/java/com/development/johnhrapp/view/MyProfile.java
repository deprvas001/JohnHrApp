package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityMyProfileBinding;

public class MyProfile extends AppCompatActivity implements View.OnClickListener {
ActivityMyProfileBinding myProfileBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myProfileBinding = DataBindingUtil.setContentView(this,R.layout.activity_my_profile);
        setClickListener();
    }

    private void setClickListener(){
        myProfileBinding.back.setOnClickListener(this);
        myProfileBinding.menu.setOnClickListener(this);
        myProfileBinding.btnCancelJob.setOnClickListener(this);
        myProfileBinding.setting.setOnClickListener(this);
        myProfileBinding.editExperience.setOnClickListener(this);
        myProfileBinding.personalInfo.setOnClickListener(this);
        myProfileBinding.editBankInfo.setOnClickListener(this);
        myProfileBinding.editProfile.setOnClickListener(this);

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

            case R.id.btn_cancel_job:
                startActivity(new Intent(this,CancelJob.class));
                break;

            case R.id.setting:
                startActivity(new Intent(this,SettingScreen.class));
                break;

            case R.id.edit_experience:
                startActivity(new Intent(this,EditExperience.class));
                break;

            case R.id.personal_info:
                startActivity(new Intent(this,EditPersonalInfo.class));
                break;

            case R.id.edit_bank_info:
                startActivity(new Intent(this,EditBankInfo.class));
                break;

            case R.id.edit_profile:
                startActivity(new Intent(this,EditProfile.class));
                break;


        }
    }
}
