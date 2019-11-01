package com.development.johnhrapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.development.johnhrapp.R;
import com.development.johnhrapp.model.UpcomingShift;
import com.development.johnhrapp.view.ViewJobOne;

import java.util.List;

public class MyJobAdapter extends RecyclerView.Adapter<MyJobAdapter.MyViewHolder> {
    private List<UpcomingShift> shiftList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, date, address,upcoming_details;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.sales_txt);
            date = (TextView) view.findViewById(R.id.date_value);
            address = (TextView) view.findViewById(R.id.address_value);
            upcoming_details = (TextView)view.findViewById(R.id.view);
        }
    }


    public MyJobAdapter(Context context,List<UpcomingShift> shiftList) {
        this.shiftList = shiftList;
        this.context = context;
    }

    @Override
    public MyJobAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.upcoming_shifts_layout, parent, false);

        return new MyJobAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyJobAdapter.MyViewHolder holder, int position) {
        UpcomingShift shift = shiftList.get(position);
        holder.title.setText(shift.getTitle());
        holder.date.setText(shift.getDate());
        holder.address.setText(shift.getAddress());

        holder.upcoming_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ViewJobOne.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return shiftList.size();
    }
}
