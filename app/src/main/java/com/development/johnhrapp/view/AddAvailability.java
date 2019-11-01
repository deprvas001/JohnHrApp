package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityAddAvailabilityBinding;

import java.util.ArrayList;
import java.util.List;

public class AddAvailability extends AppCompatActivity implements View.OnClickListener {
ActivityAddAvailabilityBinding addAvailabilityBinding;
    List<String> from = new ArrayList<String>();
    List<String> to = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_availability);
        addAvailabilityBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_availability);
        setSpinner();
        setClickListener();
    }

    private void setSpinner(){
        from.add("From");
        to.add("To");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, from);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        addAvailabilityBinding.from.setAdapter(dataAdapter);


        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, to);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        addAvailabilityBinding.to.setAdapter(dataAdapter1);
    }

    private void setClickListener(){
        addAvailabilityBinding.back.setOnClickListener(this);
        addAvailabilityBinding.menu.setOnClickListener(this);
        addAvailabilityBinding.btnSave.setOnClickListener(this);
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

            case R.id.btn_save:
                finish();
                break;
        }
    }
}
