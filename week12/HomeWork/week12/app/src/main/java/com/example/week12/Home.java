package com.example.week12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button Report1_button = findViewById(R.id.Report1_Button);
        Button Report2_button = findViewById(R.id.Report2_Button);
        Button Report3_button = findViewById(R.id.Report3_Button);

        Report1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Report1.class);
                startActivity(intent);
            }
        });

        Report2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Report2.class);
                startActivity(intent);
            }
        });

        Report3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Report3.class);
                startActivity(intent);
            }
        });
    }
}