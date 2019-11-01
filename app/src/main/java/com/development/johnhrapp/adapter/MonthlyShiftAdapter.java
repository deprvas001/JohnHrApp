package com.development.johnhrapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.development.johnhrapp.R;
import com.development.johnhrapp.model.MonthlyShift;
import com.development.johnhrapp.model.UpcomingShift;

import java.util.List;

public class MonthlyShiftAdapter extends RecyclerView.Adapter<MonthlyShiftAdapter.MyViewHolder> {

    private List<MonthlyShift> shiftList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, date, address;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.sales_txt);
            date = (TextView) view.findViewById(R.id.date_value);
            address = (TextView) view.findViewById(R.id.address_value);
        }
    }


    public MonthlyShiftAdapter(List<MonthlyShift> shiftList) {
        this.shiftList = shiftList;
    }

    @Override
    public MonthlyShiftAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.month_shift_layout, parent, false);

        return new MonthlyShiftAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MonthlyShiftAdapter.MyViewHolder holder, int position) {
        MonthlyShift shift = shiftList.get(position);
        holder.title.setText(shift.getTitle());
        holder.date.setText(shift.getDate());
        holder.address.setText(shift.getAddress());
    }

    @Override
    public int getItemCount() {
        return shiftList.size();
    }
}
