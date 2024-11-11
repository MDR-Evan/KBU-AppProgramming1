package com.example.week10;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Report1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);

        TextView textView = findViewById(R.id.textView);

        Report1_F fragment = new Report1_F();
        fragment.setTextView(textView);
    }
}