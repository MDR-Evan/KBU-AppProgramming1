package com.example.week5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class Report2 extends AppCompatActivity {
    float C;
    float F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);

        TextView c_tem = findViewById(R.id.c_tem);
        SeekBar c_seekbar = findViewById(R.id.c_seekbar);
        c_seekbar.setProgress(100);
        RadioButton ctof = findViewById(R.id.ctof);
        TextView c_result = findViewById(R.id.c_result);
        TextView c_text1 = findViewById(R.id.c_text1);
        TextView c_text2 = findViewById(R.id.c_text2);
        TextView c_text3 = findViewById(R.id.c_text3);

        TextView f_tem = findViewById(R.id.f_tem);
        SeekBar f_seekbar = findViewById(R.id.f_seekbar);
        f_seekbar.setProgress(100);
        RadioButton ftoc = findViewById(R.id.ftoc);
        TextView f_result = findViewById(R.id.f_result);
        TextView f_text1 = findViewById(R.id.f_text1);
        TextView f_text2 = findViewById(R.id.f_text2);

        Button trans = findViewById(R.id.trans);
        Button clear = findViewById(R.id.clear);



        c_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                C = c_seekbar.getProgress() - 100;
                c_tem.setText(String.format("%.2f", C));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        f_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                F = f_seekbar.getProgress() - 100;
                f_tem.setText(String.format("%.2f",F));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float c_temp = 0;
                float f_temp = 0;
                int button = view.getId();

                if (ctof.isChecked()) {
                    if (-100 <= C && C <= 100) {
                        if (button == R.id.trans) {
                            f_temp = (float) ((C * 1.8) + 32);
                            c_text1.setText("섭씨온도 : ");
                            c_text2.setText("℃");
                            c_text3.setText("는");
                            c_result.setText(String.format("%.2f", C));
                            f_text1.setText("화씨온도 : ");
                            f_text2.setText("℉");
                            f_result.setText(String.format("%.2f", f_temp));
                        } else {
                            c_seekbar.setProgress(100);
                            f_seekbar.setProgress(100);
                            c_text1.setText("");
                            c_text2.setText("");
                            c_text3.setText("");
                            c_result.setText("");
                            f_text1.setText("");
                            f_text2.setText("");
                            f_result.setText("");
                        }
                    }
                } else {
                    if (-100 <= F && F <= 100) {
                        if (button == R.id.trans) {
                            c_temp = (float) ((F - 32) / 1.8);
                            c_text1.setText("섭씨온도 : ");
                            c_text2.setText("℃");
                            c_text3.setText("는");
                            c_result.setText(String.format("%.2f", c_temp));
                            f_text1.setText("화씨온도 : ");
                            f_text2.setText("℉");
                            f_result.setText(String.format("%.2f", F));
                        } else {
                            c_seekbar.setProgress(100);
                            f_seekbar.setProgress(100);
                            c_text1.setText("");
                            c_text2.setText("");
                            c_text3.setText("");
                            c_result.setText("");
                            f_text1.setText("");
                            f_text2.setText("");
                            f_result.setText("");
                        }
                    }
                }
            }
        };

        trans.setOnClickListener(onClickListener);
        clear.setOnClickListener(onClickListener);
    }
}