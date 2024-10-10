package com.example.week5;

import android.os.Bundle;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Report3 extends AppCompatActivity {
    int temp = 165;
    int Kg;
    float M;
    float BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report3);

        ImageButton plus = findViewById(R.id.plus);
        ImageButton minus = findViewById(R.id.minus);

        SeekBar weight_seekbar = findViewById(R.id.weight_seekbar);

        Button bmi = findViewById(R.id.bmi);

        TextView height_result = findViewById(R.id.height_result);
        TextView cm = findViewById(R.id.cm);

        TextView weight_result = findViewById(R.id.weight_result);
        TextView kg = findViewById(R.id.kg);
        TextView bmi_result = findViewById(R.id.bmi_result);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int check = view.getId();

                if (check == plus.getId()) {
                    if (210 <= temp) {
                        Toast.makeText(getBaseContext(), "더이상 증가할 수 없음",Toast.LENGTH_SHORT).show();
                    } else {
                        temp++;
                    }
                } else if (check == minus.getId()) {
                    if (temp <= 120) {
                        Toast.makeText(getBaseContext(), "더이상 감소할 수 없음",Toast.LENGTH_SHORT).show();
                    } else {
                        temp--;
                    }
                } else {
                    if (temp < 120 || 210 < temp && Kg < 45 || 140 < Kg) {
                        Toast.makeText(getBaseContext(), "필수 정보가 입력되지 않았습니다.",Toast.LENGTH_SHORT).show();
                    } else {
                        M = temp * 0.01f;
                        BMI = Kg / (M * M);
                        String BMI_Text;

                        if (BMI < 16.0f) {
                            BMI_Text = "체중 부족";
                        } else if (16.0f <= BMI && BMI < 18.5f) {
                            BMI_Text = "저체중";
                        } else if (18.5f <= BMI && BMI < 25.0f) {
                            BMI_Text = ("정상체중");
                        } else if (25.0f <= BMI && BMI < 30.0f) {
                            BMI_Text = "과체중";
                        } else {
                            BMI_Text = "비만";
                        }

                        bmi_result.setText(String.format("BMI : %.2f\n결과 : %s", BMI, BMI_Text));
                    }
                }

                height_result.setText(String.format("%d", temp));
                cm.setText("Cm");
            }
        };

        plus.setOnClickListener(onClickListener);
        minus.setOnClickListener(onClickListener);
        bmi.setOnClickListener(onClickListener);

        weight_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Kg = weight_seekbar.getProgress() + 45;
                weight_result.setText(String.format("%d", Kg));
                kg.setText("Kg");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}