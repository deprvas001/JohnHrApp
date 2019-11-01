package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityEditPersonalInfoBinding;

public class EditPersonalInfo extends AppCompatActivity implements View.OnClickListener {
ActivityEditPersonalInfoBinding infoBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        infoBinding = DataBindingUtil.setContentView(this,R.layout.activity_edit_personal_info);
       setClickListener();
    }

    private void setClickListener(){
        infoBinding.back.setOnClickListener(this);
        infoBinding.btnSave.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;

            case R.id.btn_save:
                finish();
                break;
        }

    }
}
