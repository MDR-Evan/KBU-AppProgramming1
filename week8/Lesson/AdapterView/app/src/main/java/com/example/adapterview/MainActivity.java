package com.example.adapterview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ListView");
        arrayList.add("Expandable ListView");
        arrayList.add("GridView");
        arrayList.add("Spinner");
        arrayList.add("gallay");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, arrayList);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = null;
        switch (i) {
            case 0:
                intent = new Intent(this, SampleListView.class);
                break;
            case 1 :
                intent = new Intent(this, SampleListView.class);
                break;
            case 2 :
                intent = new Intent(this, SampleListView.class);
                break;
            case 3 :
                intent = new Intent(this, SampleSpinner.class);
                break;
        }
        startActivity(intent);
    }


}