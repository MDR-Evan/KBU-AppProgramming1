package com.example.button;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    // textView를 클래스 멤버 변수로 선언
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        // textView 초기화
        textView = findViewById(R.id.textView);
    }

    public void buttonClicked(View view) {
        int check = view.getId();
        if (check == R.id.r_button) {
            textView.setBackgroundColor(Color.rgb(255, 0, 0));
        } else if (check == R.id.g_button) {
            textView.setBackgroundColor(Color.rgb(0, 255, 0));
        } else if (check == R.id.b_button) {
            textView.setBackgroundColor(Color.rgb(0, 0, 255));
        }
    }
}
