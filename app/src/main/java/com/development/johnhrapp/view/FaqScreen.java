package com.development.johnhrapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.adapter.FaqAdapter;
import com.development.johnhrapp.adapter.UpcomingShiftAdapter;
import com.development.johnhrapp.databinding.ActivityFaqScreenBinding;
import com.development.johnhrapp.model.Faq;
import com.development.johnhrapp.model.UpcomingShift;

import java.util.ArrayList;
import java.util.List;

public class FaqScreen extends AppCompatActivity implements View.OnClickListener {
ActivityFaqScreenBinding faqScreenBinding;
    List<Faq> faqList = new ArrayList<>();
    private FaqAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        faqScreenBinding = DataBindingUtil.setContentView(this,R.layout.activity_faq_screen);
        setClickListener();
        setReyclerView();
        faqData();
    }

    private void setClickListener(){
        faqScreenBinding.back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }

    private void setReyclerView(){
        mAdapter = new FaqAdapter(faqList);
        mLayoutManager = new LinearLayoutManager(FaqScreen.this);
        faqScreenBinding.recyclerView.setLayoutManager(mLayoutManager);
        faqScreenBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        faqScreenBinding.recyclerView.setAdapter(mAdapter);
    }

    private void faqData(){
        faqList.clear();
        for(int i=0;i<6;i++){
            Faq faq = new Faq("Notifications","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
            faqList.add(faq);
        }
        mAdapter.notifyDataSetChanged();

    }
}
