package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Report3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report3);

        Switch switchButton = findViewById(R.id.switchButton);
        TextView switch_text = findViewById(R.id.switch_text);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        TextView toggle_text = findViewById(R.id.toggle_text);

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchButton.isChecked()) {
                    switch_text.setText("Switch is currently ON");
                } else {
                    switch_text.setText("Switch OFF");
                }
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (toggleButton.isChecked()) {
                    toggle_text.setText("Toggle Button ON");
                } else {
                    toggle_text.setText("Toggle Button OFF");
                }
            }
        });
    }
}