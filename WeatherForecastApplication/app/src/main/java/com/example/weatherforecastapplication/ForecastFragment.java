package com.example.weatherforecastapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

public class ForecastFragment extends Fragment {

    public ForecastFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast,null);

        String[] data = {
                "Sat May 23 - Clouds - 26/18",
                "Sun May 24 - Rain - 21/17",
                "Mon May 25 - Clouds - 25/15",
                "Tue May 26 - Rain - 23/15",
                "Wed May 27 - Clouds - 24/10",
                "Thu May 28 - Clouds - 26/16",
                "Fri May 29 - Clouds - 27/18",
                "Sat May 30 - Clouds - 25/19",
                "Sun May 31 - Clear - 33/17"
        };

        final List<String> LIST_SAMPLE = new ArrayList<String>(Arrays.asList(data));

        ArrayAdapter Adapter = new ArrayAdapter<String>(
                getActivity(), R.layout.list_view_item, R.id.list_item_forecast_textview, LIST_SAMPLE
        );

        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                String forecast = (String) parent.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}