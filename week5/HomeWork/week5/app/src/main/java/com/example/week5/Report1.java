package com.example.week5;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Report1 extends AppCompatActivity {
    SeekBar weight;
    TextView weight_result;
    SeekBar height;
    TextView height_result;
    TextView BMI;
    TextView BMI_result1;
    TextView BMI_result2;
    TextView BMI_result3;

    float Kg;
    float Cm;
    float M;
    float BMI_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);

        weight = findViewById(R.id.weight);
        weight_result = findViewById(R.id.weight_result);
        height = findViewById(R.id.height);
        height_result = findViewById(R.id.height_result);
        BMI = findViewById(R.id.BMI);
        BMI_result1 = findViewById(R.id.BMI_result1);
        BMI_result2 = findViewById(R.id.BMI_result2);
        BMI_result3 = findViewById(R.id.BMI_result3);

        weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Kg = (weight.getProgress() * 0.5f) + 35;
                weight_result.setText(String.format("%.1f Kg", Kg));
                calculateBMI();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        height.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Cm = (height.getProgress() * 0.5f) + 90;
                height_result.setText(String.format("%.1f Cm", Cm));
                calculateBMI();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void calculateBMI() {
        Kg = (weight.getProgress() * 0.5f) + 35;
        Cm = (height.getProgress() * 0.5f) + 90;
        if (Kg < 35 || 150 < Kg) {
            Toast.makeText(getBaseContext(),"몸무게를 입력해주세요.",Toast.LENGTH_SHORT).show();
        } else if (Cm < 90 || 230 < Cm) {
            Toast.makeText(getBaseContext(),"키를 입력해주세요.",Toast.LENGTH_SHORT).show();
        } else {
            M = Cm * 0.01f;
            BMI_value = Kg / (M * M);

            if (BMI_value < 18.5f) {
                BMI_result2.setText("저체중");
            } else if (18.5f <= BMI_value && BMI_value < 23.0f) {
                BMI_result2.setText("정상 체중");
            } else if (23.0f <= BMI_value && BMI_value < 25.0f) {
                BMI_result2.setText("과체중");
            } else if (25.0f <= BMI_value && BMI_value < 30.0f) {
                BMI_result2.setText("비만");
            } else {
                BMI_result2.setText("고도 비만");
            }
            BMI.setText(String.format("BMI : %.2f", BMI_value));
            BMI_result1.setText("당신은");
            BMI_result3.setText("입니다!");
        }
    }
}