package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityEditBankInfoBinding;

public class EditBankInfo extends AppCompatActivity implements View.OnClickListener {
ActivityEditBankInfoBinding editBankInfoBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editBankInfoBinding = DataBindingUtil.setContentView(this,R.layout.activity_edit_bank_info);
        setClickListener();
    }

    private void setClickListener(){
        editBankInfoBinding.back.setOnClickListener(this);
        editBankInfoBinding.btnSave.setOnClickListener(this);
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
