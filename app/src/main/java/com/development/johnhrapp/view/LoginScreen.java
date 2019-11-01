package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityLoginScreenBinding;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {
ActivityLoginScreenBinding screenBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenBinding = DataBindingUtil.setContentView(this,R.layout.activity_login_screen);
        setClickListener();
    }

    private void setClickListener(){
        screenBinding.btnLogin.setOnClickListener(this);
        screenBinding.forgotPassword.setOnClickListener(this);
        screenBinding.signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                startActivity(new Intent(this,HomeScreen.class));
                break;

            case R.id.forgot_password:
                startActivity(new Intent(this,ForgotScreen.class));
                break;

            case R.id.sign_up:
                startActivity(new Intent(this,SignUp.class));
                break;
        }
    }
}
