package com.example.week2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.BaseTransientBottomBar;

public class Report2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);

//      섭씨 온도 입력칸
        EditText C_editText = findViewById(R.id.C_editText);
        Button CtoF_button = findViewById(R.id.CtoF_button);
//      화씨 온도 입력칸
        EditText F_editText = findViewById(R.id.F_editText);
        Button FtoC_button = findViewById(R.id.FtoC_button);
//      온도 변환 결과
        TextView textView = findViewById(R.id.result_View);

        CtoF_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = C_editText.getText().toString();
                if (input.equals("")) {
                    Toast.makeText(getBaseContext(), "온도를 입력해주세요.",Toast.LENGTH_SHORT).show();
                } else {
                    float C = Float.parseFloat(input);
                    float trans = (float) ((9.0/5.0) * C + 32);

                    textView.setText(String.format("섭씨 온도 %.2f도는\n화씨 온도로 %.2f 입니다.", C, trans));
                    Toast.makeText(getBaseContext(), String.format("%.2f", trans),Toast.LENGTH_SHORT).show();
                }
            }
        });

        FtoC_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = F_editText.getText().toString();
                if (input.equals("")) {
                    Toast.makeText(getBaseContext(), "온도를 입력해주세요.",Toast.LENGTH_SHORT).show();
                } else {
                    float F = Float.parseFloat(input);
                    float trans = (float) ((5.0/9.0) * (F - 32));

                    textView.setText(String.format("화씨 온도 %.2f도는\n섭씨 온도로 %.2f 입니다.", F, trans));
                    Toast.makeText(getBaseContext(), String.format("%.2f", trans),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}