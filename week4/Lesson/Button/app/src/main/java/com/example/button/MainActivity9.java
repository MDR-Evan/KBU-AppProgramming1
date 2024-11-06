package com.example.button;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        Switch switch1 = findViewById(R.id.toggle);
        RadioGroup group = findViewById(R.id.group);
        RadioButton radioButton1 = findViewById(R.id.radio1);
        RadioButton radioButton2 = findViewById(R.id.radio2);
        RadioButton radioButton3 = findViewById(R.id.radio3);
        RadioButton radioButton4 = findViewById(R.id.radio4);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (switch1.isChecked()) {
                    group.setVisibility(View.VISIBLE);
                } else {
                    group.setVisibility(View.INVISIBLE);
                }
                radioButton1.performClick();
            }
        });
        
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String messeage = "";
                if (i == R.id.radio1) {
                    messeage = "초등학생이 선택됨";
                } else if (i == R.id.radio2) {
                    messeage = "중학생이 선택됨";
                } else if (i == R.id.radio3) {
                    messeage = "고등학생이 선택됨";
                } else if (i == R.id.radio4) {
                    messeage = "대학생이 선택됨";
                }

                Toast.makeText(getApplicationContext(),messeage,Toast.LENGTH_SHORT).show();
            }
        });
    }
}