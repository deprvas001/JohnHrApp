package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityNotificationShiftBinding;

public class NotificationShift extends AppCompatActivity implements View.OnClickListener {
ActivityNotificationShiftBinding notificationShiftBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notificationShiftBinding = DataBindingUtil.setContentView(this,R.layout.activity_notification_shift);
        setClickListener();
    }

    private void setClickListener(){
        notificationShiftBinding.back.setOnClickListener(this);
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
