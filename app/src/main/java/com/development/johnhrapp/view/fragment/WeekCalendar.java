package com.development.johnhrapp.view.fragment;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.FragmentWeekCalendarBinding;
import com.development.johnhrapp.view.AddAvailability;
import com.development.johnhrapp.view.AddHoliday;

public class WeekCalendar extends Fragment implements View.OnClickListener {
FragmentWeekCalendarBinding calendarBinding;
View view;

    public WeekCalendar() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        calendarBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_week_calendar, container, false);
        view = calendarBinding.getRoot();
        setClickListener();
        return view;
    }

    private void setClickListener(){
        calendarBinding.btnAvailable.setOnClickListener(this);
        calendarBinding.addHoliday.setOnClickListener(this);
        calendarBinding.image1.setOnClickListener(this);
        calendarBinding.image2.setOnClickListener(this);
        calendarBinding.image3.setOnClickListener(this);
        calendarBinding.image4.setOnClickListener(this);
        calendarBinding.image5.setOnClickListener(this);
        calendarBinding.image6.setOnClickListener(this);
        calendarBinding.image7.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id. btn_available:
                startActivity(new Intent(getActivity(), AddAvailability.class));
                break;

            case R.id. add_holiday:
                startActivity(new Intent(getActivity(), AddHoliday.class));
                break;

            case R.id. image1:
                showHourPicker();
                break;

            case R.id. image2:
                showHourPicker();
                break;

            case R.id. image3:
                showHourPicker();
                break;

            case R.id. image4:
                showHourPicker();
                break;

            case R.id. image5:
                showHourPicker();
                break;

            case R.id. image6:
                showHourPicker();
                break;

            case R.id. image7:
                showHourPicker();
                break;
        }
    }

    public void showHourPicker() {
        final java.util.Calendar myCalender = java.util.Calendar.getInstance();
        int hour = myCalender.get(java.util.Calendar.HOUR_OF_DAY);
        int minute = myCalender.get(java.util.Calendar.MINUTE);


        TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if (view.isShown()) {
                    myCalender.set(java.util.Calendar.HOUR_OF_DAY, hourOfDay);
                    myCalender.set(java.util.Calendar.MINUTE, minute);

                }
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_NoActionBar, myTimeListener, hour, minute, true);
        timePickerDialog.setTitle("Choose hour:");
        timePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        timePickerDialog.show();
    }


}
