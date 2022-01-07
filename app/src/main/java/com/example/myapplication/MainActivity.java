package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mGetBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        setContentView(R.layout.holidays);
        mGetBtn = (Button) findViewById(R.id.get_btn);
        String result = getHtml("test");
        ListView listView = (ListView) findViewById(R.id.list_test);
        final List<Holiday> adapterData = new ArrayList<Holiday>();

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
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
                data, R.layout.holidays, new String[]{"date", "localName", "name", "countryCode", "type"},
                new int[]{R.id.date, R.id.localName, R.id.name, R.id.countryCode, R.id.type});
        mGetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListView listView = findViewById(R.id.list_test);
                final List<String> adapterData = new ArrayList<String>();
                for (int i = 0; i < 20; i++) {
                    adapterData.add("ListItem" + i);
                }
                listView.setAdapter(adapter);
            }
        });

    }

    public static String getHtml(String url) {
        HtmlService service = new HtmlService();
        String test = "https://date.nager.at/api/v2/publicholidays/2022/BY";
        String result = "123";
        try {
            result = service.getHtml(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}