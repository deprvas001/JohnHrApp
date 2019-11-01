package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityEditProfileBinding;

import java.util.ArrayList;
import java.util.List;

public class EditProfile extends AppCompatActivity implements View.OnClickListener {
ActivityEditProfileBinding profileBinding;
    List<String> categories = new ArrayList<String>();
    List<String> sub_categories = new ArrayList<>();
    List<String> shift = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileBinding = DataBindingUtil.setContentView(this,R.layout.activity_edit_profile);
        setClickListener();
        setSpinner();
    }

    private void setClickListener(){
        profileBinding.back.setOnClickListener(this);
        profileBinding.btnSave.setOnClickListener(this);
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

    private void setSpinner(){
        categories.add("Choose your category");
        sub_categories.add("Choose your sub category");
        shift.add("Shifts / Week");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        profileBinding.category.setAdapter(dataAdapter);


        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sub_categories);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        profileBinding.subCategory.setAdapter(dataAdapter1);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shift);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        profileBinding.shift.setAdapter(dataAdapter2);
    }
}
