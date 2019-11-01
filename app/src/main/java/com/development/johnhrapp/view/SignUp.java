package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    ActivitySignUpBinding signUpBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);
        setClickListener();
    }

    private void setClickListener(){
        signUpBinding.back.setOnClickListener(this);
        signUpBinding.signin.setOnClickListener(this);
        signUpBinding.btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;

            case R.id.signin:
                finish();
                break;

            case R.id.btn_signup:
                startActivity(new Intent(this,SetupProfile.class));
                break;
        }
    }
}
