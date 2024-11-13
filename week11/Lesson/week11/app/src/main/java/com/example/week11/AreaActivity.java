package com.example.week11;

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

public class AreaActivity extends AppCompatActivity {
    private final Double Official = 3.305785;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        EditText edit = findViewById(R.id.area_edit1);
        TextView text = findViewById(R.id.area_text1);
        Button button1 = findViewById(R.id.area_button1),
               button2 = findViewById(R.id.area_button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToMeter(edit, text);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToPyung(edit, text);
            }
        });
    }

    private void changeToPyung(EditText edit, TextView text) {
        String value = edit.getText().toString();

        if (value.isEmpty()) {
            Toast.makeText(getBaseContext(), "입력하세요", Toast.LENGTH_SHORT).show();
        } else {
            Double result = (double) (Math.round(Double.parseDouble(value) / Official * 100) / 100);
            text.setText(String.format("%.2f ㎡", value));
        }
    }

    private void changeToMeter(EditText edit, TextView text) {
        String value = edit.getText().toString();

        if (value.isEmpty()) {
            Toast.makeText(getBaseContext(), "입력하세요", Toast.LENGTH_SHORT).show();
        } else {
            Double result = Double.parseDouble(value) * Official;
            text.setText(String.format("%.2f ㎡", value));
        }
    }
}