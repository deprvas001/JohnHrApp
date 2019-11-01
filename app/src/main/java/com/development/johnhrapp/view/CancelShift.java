package com.development.johnhrapp.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityCancelJobBinding;
import com.development.johnhrapp.databinding.ActivityCancelShiftBinding;

public class CancelShift extends AppCompatActivity implements View.OnClickListener {
    ActivityCancelShiftBinding shiftBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shiftBinding = DataBindingUtil.setContentView(this,R.layout.activity_cancel_shift);
        setClickListener();
    }

    private void setClickListener(){
        shiftBinding.back.setOnClickListener(this);
        shiftBinding.btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.back:
                finish();
                break;

            case  R.id.btn_cancel:
                 showCustomDialog();
                break;
        }
    }

    private void showCustomDialog() {
        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        ViewGroup viewGroup = findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        View dialogView = LayoutInflater.from(this).inflate(R.layout.cancel_shift_dialog, viewGroup, false);

        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);

        //finally creating the alert dialog and displaying it
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
    }
}
