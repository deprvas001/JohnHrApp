package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityAddPersonalInfoBinding;

public class AddPersonalInfo extends AppCompatActivity implements View.OnClickListener {
ActivityAddPersonalInfoBinding addPersonalInfoBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPersonalInfoBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_personal_info);
        setClickListener();
    }

    private void setClickListener(){
        addPersonalInfoBinding.back.setOnClickListener(this);
        addPersonalInfoBinding.btnNext.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;

            case R.id.btn_next:
                startActivity(new Intent(this,SignUpComplete.class));
                break;
        }
    }
}
