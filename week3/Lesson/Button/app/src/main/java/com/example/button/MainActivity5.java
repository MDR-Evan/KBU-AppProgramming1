//OnClickListener를 implement하는 방법

package com.example.button;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 명시적 캐스팅 추가
        textView = (TextView) findViewById(R.id.textView);

        Button r_button = findViewById(R.id.r_button);
        r_button.setOnClickListener(this);
        Button g_button = findViewById(R.id.g_button);
        g_button.setOnClickListener(this);
        Button b_button = findViewById(R.id.b_button);
        b_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
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
