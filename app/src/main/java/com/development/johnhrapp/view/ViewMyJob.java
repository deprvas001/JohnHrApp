package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityViewMyJobBinding;

public class ViewMyJob extends AppCompatActivity implements View.OnClickListener {
    ActivityViewMyJobBinding myJobBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myJobBinding = DataBindingUtil.setContentView(this,R.layout.activity_view_my_job);
        setClickListener();
    }

    private void setClickListener(){
        myJobBinding.back.setOnClickListener(this);
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
