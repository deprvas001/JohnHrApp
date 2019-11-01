package com.development.johnhrapp.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        }
    }


}
