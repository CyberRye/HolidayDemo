package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.MyViewHolder> {

    private List<Holiday> holidayList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;


    public HolidayAdapter(Context context, List<Holiday> holidayList) {
        this.mContext = context;
        this.holidayList = holidayList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.itemlayout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Holiday holiday = holidayList.get(position);

        holder.mDate.setText(holiday.getDate());
        holder.mName.setText(holiday.getName());
        holder.mLocalName.setText(holiday.getLocalName());
        holder.mCountryCode.setText(holiday.getCountryCode());
        holder.mType.setText(holiday.getType());

    }

    @Override
    public int getItemCount() {
        return holidayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mDate;
        TextView mLocalName;
        TextView mName;
        TextView mCountryCode;
        TextView mType;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mDate = itemView.findViewById(R.id.textDate);
            this.mName = itemView.findViewById(R.id.textName);
            this.mLocalName = itemView.findViewById(R.id.textLocalName);
            this.mCountryCode = itemView.findViewById(R.id.textCountryCode);
            this.mType = itemView.findViewById(R.id.textType);
        }
    }

//    private Context context;
//    private ArrayList<Holiday> dataList;
//
//    public HolidayAdapter(Context mContext, ArrayList<Holiday> dataList) {
//        this.dataList = dataList;
//        this.context = mContext;
//    }
//
//    public HolidayAdapter() {
//    }
//
//    @Override
//    public HolidayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.itemlayout, parent, false);
//
//        return new HolidayHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull HolidayAdapter.HolidayHolder holder, int position) {
//        Holiday holiday = dataList.get(position);
//        System.out.println("xxxxxxxxxxxxx" + holiday.getDate());
//        System.out.println("xxxxxxxxxxxxx" + holiday.getName());
//        System.out.println("xxxxxxxxxxxxx" + holiday.getCountries());
//        System.out.println("xxxxxxxxxxxxx" + holder);
//        System.out.println("xxxxxxxxxxxxx" + holder.textDate);
////        holder.date.setText(holiday.getDate());
//        holder.textDate = new TextView(this.context);
//        holder.textDate.setText(holiday.getDate());
//        holder.textName = new TextView(this.context);
//        holder.textName.setText(holiday.getName());
//        System.out.println("11111111111111    " + holder);
//    }
//
//    @Override
//    public int getItemCount() {
//        return this.dataList.size();
//    }
//
//
//    class HolidayHolder extends RecyclerView.ViewHolder {
//        public TextView textDate;
//        public TextView textName;
//
//        //    public HolidayHolder(LayoutInflater inflater, ViewGroup parent) {
////        super(inflater.inflate(R.layout.itemlayout, parent, false));
////    }
//        public HolidayHolder(View itemView) {
//            super(itemView);
//            textDate = (TextView) itemView.findViewById(R.id.textDate);
//            textName = (TextView) itemView.findViewById(R.id.textName);
//        }
//
//    }

}

