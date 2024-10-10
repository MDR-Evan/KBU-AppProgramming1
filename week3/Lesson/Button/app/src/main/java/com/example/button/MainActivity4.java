//내부 익명 클래스

package com.example.button;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TextView textView = findViewById(R.id.textView);
        OnClickListener onClickListener = new OnClickListener(textView);

        Button r_button = findViewById(R.id.r_button);
        r_button.setOnClickListener(onClickListener);
        Button g_button = findViewById(R.id.g_button);
        g_button.setOnClickListener(onClickListener);
        Button b_button = findViewById(R.id.b_button);
        b_button.setOnClickListener(onClickListener);
    }
}