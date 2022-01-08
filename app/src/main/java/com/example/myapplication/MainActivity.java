package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mGetBtn = null;
    private RecyclerView recyclerView;
    private ArrayList<Holiday> holidayList;
    private HolidayAdapter holidayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        initView();
        iniData();
        mGetBtn = findViewById(R.id.button);
        mGetBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                initEvent();
            }
        });

//        ArrayList<Holiday> adapterData = getHolidayList();
//        holidayAdapter = new HolidayAdapter(this, adapterData);
//
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setAdapter(holidayAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


//        setContentView(R.layout.itemlayout);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        HolidayAdapter adapter = new HolidayAdapter(this, (ArrayList<Holiday>) adapterData);
//        RecyclerView.Adapter = adapter;


//        mGetBtn = (Button) findViewById(R.id.get_btn);
//        List<Holiday> adapterData = getHolidayList();
//
//        List<HashMap<String, Object>> data = buildAdapter(adapterData);
//        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
//                data, R.layout.holidays, new String[]{"date", "localName", "name", "countryCode", "type"},
//                new int[]{R.id.date, R.id.localName, R.id.name, R.id.countryCode, R.id.type});
//        mGetBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                ListView listView = findViewById(R.id.list_test);
//                final List<String> adapterData = new ArrayList<String>();
//                for (int i = 0; i < 20; i++) {
//                    adapterData.add("ListItem" + i);
//                }
//                listView.setAdapter(adapter);
//            }
//        });

    }

    public void initEvent() {
        holidayAdapter = new HolidayAdapter(this, holidayList);
        recyclerView.setAdapter(holidayAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void iniData() {

        holidayList = getHolidayList();

    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    public static void getComments(View view) {

    }

    public static List<HashMap<String, Object>> buildAdapter(List<Holiday> adapterData) {
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        for (Holiday holiday : adapterData) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put("date", holiday.getDate());
            item.put("localName", holiday.getLocalName());
            item.put("name", holiday.getName());
            item.put("countryCode", holiday.getCountryCode());
            item.put("fixed", holiday.isFixed());
            item.put("global", holiday.isGlobal());
            item.put("counties", holiday.getCountries());
            item.put("launchYear", holiday.getLaunchYear());
            item.put("type", holiday.getType());
            data.add(item);
        }
        return data;
    }

    public static ArrayList<Holiday> getHolidayList() {
        String test = "https://date.nager.at/api/v2/publicholidays/2022/BY";

        String result = getHtml(test);
        final ArrayList<Holiday> adapterData = new ArrayList<Holiday>();

        try {
            JSONArray elemList = new JSONArray(result);
            for (int i = 0; i < elemList.length(); i++) {
                JSONObject jsObj = elemList.getJSONObject(i);
                Holiday holiday = new Holiday();
                holiday.setDate(jsObj.getString("date"));
                holiday.setLocalName(jsObj.getString("localName"));
                holiday.setName(jsObj.getString("name"));
                holiday.setCountryCode(jsObj.getString("countryCode"));
                holiday.setFixed(jsObj.getBoolean("fixed"));
                holiday.setGlobal(jsObj.getBoolean("global"));
                holiday.setCountries(jsObj.getString("counties"));
                holiday.setLaunchYear(jsObj.getString("launchYear"));
                holiday.setType(jsObj.getString("type"));
                adapterData.add(holiday);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return adapterData;
    }

    public static String getHtml(String url) {
        HtmlService service = new HtmlService();
        String result = "123";
        try {
            result = service.getHtml(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}