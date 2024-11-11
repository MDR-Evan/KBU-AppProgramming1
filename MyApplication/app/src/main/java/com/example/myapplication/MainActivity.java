package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    SeekBar R_seekBar, G_seekBar, B_seekBar;
    TextView R_textView, G_textView, B_textView;
    TextView textColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        R_seekBar = findViewById(R.id.R_seekBar);
        G_seekBar = findViewById(R.id.G_seekBar);
        B_seekBar = findViewById(R.id.B_seekBar);

        R_textView = findViewById(R.id.R_textView);
        G_textView = findViewById(R.id.G_textView);
        B_textView = findViewById(R.id.B_textView);
        textColor = findViewById(R.id.textColor);

        R_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeColorText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        G_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeColorText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        B_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeColorText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void changeColorText() {
        int red = R_seekBar.getProgress();
        int green = G_seekBar.getProgress();
        int blue = B_seekBar.getProgress();

        int rgb = Color.rgb(red, green, blue);
        String temp = String.format("%2H%2H%2H", red, green, blue);
        String code = temp.replaceAll(" ", "0");

        R_textView.setText(red + "(" + (red == 0 ? "00" : String.format("%2H", red)) + ")");
        G_textView.setText(green + "(" + (green == 0 ? "00" : String.format("%2H", green)) + ")");
        B_textView.setText(blue + "(" + (blue == 0 ? "00" : String.format("%2H", blue)) + ")");

        if(code.compareTo("800000") < 0) {
            textColor.setTextColor(Color.WHITE);
        } else {
            textColor.setTextColor(Color.BLACK);
        }

        textColor.setBackgroundColor(rgb);
        textColor.setText(code);
    }
}