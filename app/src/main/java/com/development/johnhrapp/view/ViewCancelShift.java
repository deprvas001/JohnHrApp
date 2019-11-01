package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityViewCancelShiftBinding;
import com.development.johnhrapp.databinding.ActivityViewMyJobBinding;

public class ViewCancelShift extends AppCompatActivity implements View.OnClickListener {
ActivityViewCancelShiftBinding cancelShiftBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cancelShiftBinding = DataBindingUtil.setContentView(this,R.layout.activity_view_cancel_shift);
       setClickListener();
    }

    private void setClickListener(){
        cancelShiftBinding.back.setOnClickListener(this);
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
