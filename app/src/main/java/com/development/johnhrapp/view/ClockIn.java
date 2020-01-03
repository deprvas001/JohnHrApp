package com.development.johnhrapp.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityClockInBinding;

public class ClockIn extends AppCompatActivity implements View.OnClickListener {
ActivityClockInBinding clockInBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clockInBinding = DataBindingUtil.setContentView(this,R.layout.activity_clock_in);
        setClickListener();
    }

    private void setClickListener(){
        clockInBinding.back.setOnClickListener(this);
        clockInBinding.clockIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;

            case R.id.clock_in:
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 1);
             //  startActivity(new Intent(this,ViewMyJob.class));
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            // do whatever you want with the image now
            startActivity(new Intent(this, ViewMyJob.class));
        }
    }

    private void showCustomDialog() {
        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        ViewGroup viewGroup = findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_aleart_dialog, viewGroup, false);

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
