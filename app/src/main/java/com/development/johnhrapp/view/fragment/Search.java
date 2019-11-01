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
import android.widget.ArrayAdapter;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.FragmentSearchBinding;
import com.development.johnhrapp.view.HomeScreen;
import com.development.johnhrapp.view.SortingJobSearch;

import java.util.ArrayList;
import java.util.List;

public class Search extends Fragment implements View.OnClickListener {
    FragmentSearchBinding searchBinding;
    View view;
    List<String> category = new ArrayList<String>();
    List<String> sub_category = new ArrayList<>();
    List<String> shift_hour = new ArrayList<>();
    List<String> area = new ArrayList<>();

    public Search() {
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
        searchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        view = searchBinding.getRoot();
        initializeView();
        setSpinner();
        setClickListener();
        return view;
    }

    private void initializeView(){
        ((HomeScreen)getActivity()).activityHomeScreenBinding.toolbarText.setText(getString(R.string.search_job));
    }

    private void setSpinner() {
        category.add("Select Category");
        sub_category.add("Select Sub Category");
        shift_hour.add("Select Sub Category");
        area.add("Choose Miles");
        // Creating adapter for spinner
        ArrayAdapter<String>  dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, category);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        searchBinding.category.setAdapter(dataAdapter);


        ArrayAdapter<String>  sub_dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, sub_category);
        sub_dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchBinding.subCategory.setAdapter(sub_dataAdapter);

        ArrayAdapter<String> shift_dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, shift_hour);
        shift_dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchBinding.shiftHour.setAdapter(shift_dataAdapter);

        ArrayAdapter<String> area_dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, area);
        area_dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchBinding.area.setAdapter(area_dataAdapter);
    }

    private void setClickListener(){
        searchBinding.quickSearch.setOnClickListener(this);
        searchBinding.btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.quick_search:
                startActivity(new Intent(getActivity(), SortingJobSearch.class));
                break;

            case R.id.btn_search:
                startActivity(new Intent(getActivity(), SortingJobSearch.class));
                break;
        }
    }
}
