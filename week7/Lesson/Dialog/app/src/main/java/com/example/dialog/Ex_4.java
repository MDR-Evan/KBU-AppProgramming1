package com.example.dialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ex_4 extends AppCompatActivity {
    double weight = 0.0;
    double height = 0.0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4);

        textView = findViewById(R.id.textView1);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("BMI 계산", "당신의 체중(weight)과 신장(height)를 입력해 주세요.");
            }
        });
    }

    private void showDialog(String title, String message) {
        LinearLayout linearLayout = new LinearLayout(Ex_4.this);

        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView textView = new TextView(Ex_4.this);
        textView.setText("체중");
        textView.setTextColor(Color.BLUE);
        TextView textView1 = new TextView(Ex_4.this);
        textView.setText("신장");
        textView.setTextColor(Color.BLUE);
        SeekBar seekBar = new SeekBar(Ex_4.this);
        SeekBar seekBar1 = new SeekBar(Ex_4.this);
        seekBar.setMax(250);
        seekBar1.setMax(300);
        linearLayout.addView(textView);
        linearLayout.addView(textView1);
        linearLayout.addView(seekBar);
        linearLayout.addView(seekBar1);

        AlertDialog.Builder builder = new AlertDialog.Builder(Ex_4.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setView(linearLayout);
        builder.setPositiveButton("입력", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (weight == 0.0 || height == 0.0) {
                    alertDialog("알림", "데이터가 입력되지 않았습니다.");
                } else {
                    double test = (height / 100.0);
                    double bmi = weight / (test * test);

                    textView1.setText(bmi + "");
                }
            }
        });
        builder.create();
        builder.show();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                weight = (i * 5) / 10.0 + 35.0;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                height = ((i * 5) / 10.0) + 90;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void alertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Ex_4.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ex_4.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        builder.create();
        builder.show();
    }
}