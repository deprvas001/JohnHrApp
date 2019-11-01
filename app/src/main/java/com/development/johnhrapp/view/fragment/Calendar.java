package com.development.johnhrapp.view.fragment;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.CalendarLayoutBinding;
import com.development.johnhrapp.databinding.FragmentJobsBinding;
import com.development.johnhrapp.view.HomeScreen;

import java.util.ArrayList;
import java.util.List;

public class Calendar   extends Fragment {
CalendarLayoutBinding calendarLayoutBinding;
    View view;
    public Calendar() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        calendarLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.calendar_layout, container, false);
        view = calendarLayoutBinding.getRoot();
        setView();
        return view;
    }

    private void setView(){
        ((HomeScreen)getActivity()).activityHomeScreenBinding.toolbarText.setText(getString(R.string.calendar));
        setUpViewPager(calendarLayoutBinding.viewpager);
        calendarLayoutBinding.resultTabs.setupWithViewPager(calendarLayoutBinding.viewpager);

        LinearLayout linearLayout = (LinearLayout)calendarLayoutBinding.resultTabs.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(getResources().getColor(R.color.tab_border));
        drawable.setSize(3, 2);
        //linearLayout.setDividerPadding(10);
        linearLayout.setDividerDrawable(drawable);
    }

    private void setUpViewPager(ViewPager viewPager){
        Jobs.Adapter adapter = new Jobs.Adapter(getChildFragmentManager());
        adapter.addFragment(new MonthCalendar(), "MONTH");
        adapter.addFragment(new WeekCalendar(), "WEEK");
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
