package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivitySignUpBinding;
import com.development.johnhrapp.databinding.ActivitySignUpCompleteBinding;

public class SignUpComplete extends AppCompatActivity  implements View.OnClickListener {
ActivitySignUpCompleteBinding completeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        completeBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up_complete);
        setClickListener();
    }

    private void setClickListener(){
        completeBinding.btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_search:
                startActivity(new Intent(this,HomeScreen.class));
                break;
        }
    }
}
