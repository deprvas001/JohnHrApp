package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityAddExperienceBinding;

import java.util.ArrayList;
import java.util.List;

public class AddExperience extends AppCompatActivity  implements View.OnClickListener{
ActivityAddExperienceBinding addExperienceBinding;
    List<String> categories = new ArrayList<String>();
    List<String> sub_categories = new ArrayList<>();
    List<String> shift = new ArrayList<>();
    List<String> country = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addExperienceBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_experience);
        setSpinner();
        setClickListener();
    }

    private void setSpinner(){
        categories.add("Experience Sector");
        sub_categories.add("Years");
        shift.add("Months");
        country.add("Choose Country");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        addExperienceBinding.experienceSector.setAdapter(dataAdapter);


        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sub_categories);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        addExperienceBinding.year.setAdapter(dataAdapter1);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shift);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        addExperienceBinding.month.setAdapter(dataAdapter2);

        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, country);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        addExperienceBinding.choseCountry.setAdapter(dataAdapter3);
    }

    private void setClickListener(){
        addExperienceBinding.back.setOnClickListener(this);
        addExperienceBinding.btnSave.setOnClickListener(this);
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
}
