package com.example.myapplication;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter {

    private List<Holiday> dataList;

    public HolidayAdapter(List<Holiday> dataList){
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        holder.
//        item.put("date", holiday.getDate());
//        item.put("localName", holiday.getLocalName());
//        item.put("name", holiday.getName());
//        item.put("countryCode", holiday.getCountryCode());
//        item.put("fixed", holiday.isFixed());
//        item.put("global", holiday.isGlobal());
//        item.put("counties", holiday.getCountries());
//        item.put("launchYear", holiday.getLaunchYear());
//        item.put("type", holiday.getType());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
