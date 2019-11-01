package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.adapter.NotificationAdapter;
import com.development.johnhrapp.adapter.UpcomingShiftAdapter;
import com.development.johnhrapp.databinding.ActivityNotificationScreenBinding;
import com.development.johnhrapp.model.Notification;
import com.development.johnhrapp.model.UpcomingShift;

import java.util.ArrayList;
import java.util.List;

public class NotificationScreen extends AppCompatActivity implements View.OnClickListener {
ActivityNotificationScreenBinding notificationScreenBinding;
    List<Notification> notificationList = new ArrayList<>();
    private NotificationAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_notification_screen);
        notificationScreenBinding = DataBindingUtil.setContentView(this,R.layout.activity_notification_screen);
        setOnClickListener();
        initializeView();
        setReyclerView();
        setNotification();
    }

    private void setOnClickListener(){
        notificationScreenBinding.back.setOnClickListener(this);
    }

    private void initializeView(){

    }

    private void setReyclerView(){
        mAdapter = new NotificationAdapter(notificationList);
        mLayoutManager = new LinearLayoutManager(NotificationScreen.this);
        notificationScreenBinding.recyclerView.setLayoutManager(mLayoutManager);
        notificationScreenBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        notificationScreenBinding.recyclerView.setAdapter(mAdapter);
    }

    private void setNotification(){
        notificationList.clear();
        for(int i=0;i<6;i++){
            Notification shift = new Notification("Job \"Software Engineer\" you applied for the job. ","12:35 PM 09/10/2010");
            notificationList.add(shift);
        }
        mAdapter.notifyDataSetChanged();
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
