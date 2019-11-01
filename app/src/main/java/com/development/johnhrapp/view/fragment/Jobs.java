package com.development.johnhrapp.view.fragment;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.FragmentJobsBinding;
import com.development.johnhrapp.view.HomeScreen;

import java.util.ArrayList;
import java.util.List;


public class Jobs extends Fragment {
    FragmentJobsBinding jobsBinding;
    View view;
    public Jobs() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        jobsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_jobs, container, false);
        view = jobsBinding.getRoot();
        setView();
        return view;
    }

    private void setView(){
        ((HomeScreen)getActivity()).activityHomeScreenBinding.toolbarText.setText(getString(R.string.jobs));
        setUpViewPager(jobsBinding.viewpager);
        jobsBinding.resultTabs.setupWithViewPager(jobsBinding.viewpager);

        LinearLayout linearLayout = (LinearLayout)jobsBinding.resultTabs.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(getResources().getColor(R.color.tab_border));
        drawable.setSize(3, 2);
        //linearLayout.setDividerPadding(10);
        linearLayout.setDividerDrawable(drawable);
    }

    private void setUpViewPager(ViewPager viewPager){
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new MyJobs(), "MY JOBS");
        adapter.addFragment(new AppliedJob(), "APPLIED JOBS");
        adapter.addFragment(new MyJobs(), "OFFERED JOBS");
        adapter.addFragment(new MyJobs(), "SAVED JOBS");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }



}
