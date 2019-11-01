package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityEditExperienceBinding;

public class EditExperience extends AppCompatActivity implements View.OnClickListener {
ActivityEditExperienceBinding editExperienceBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editExperienceBinding = DataBindingUtil.setContentView(this,R.layout.activity_edit_experience);
        setClickListener();
    }

    private void setClickListener(){
        editExperienceBinding.back.setOnClickListener(this);
        editExperienceBinding.addMoreExperience.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;

            case R.id.add_more_experience:
                startActivity(new Intent(this,AddExperience.class));
                break;
        }
    }
}
