package com.example.myapplication;

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

public class Report2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);

        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        Button multiply = findViewById(R.id.multiply);
        Button division = findViewById(R.id.division);
        Button remainder = findViewById(R.id.remainder);
        TextView result = findViewById(R.id.result);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int check = view.getId();
                String num1 = input1.getText().toString();
                String num2 = input2.getText().toString();

                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getBaseContext(),"입력해주세요",Toast.LENGTH_SHORT).show();
                } else {
                    int a = Integer.parseInt(num1);
                    int b = Integer.parseInt(num2);

                    if (check == R.id.plus) {
                        int plus_result = a + b;
                        result.setText(String.format("%d + %d = %d", a, b, plus_result));
                    } else if (check == R.id.minus) {
                        int minus_result = a - b;
                        result.setText(String.format("%d - %d = %d", a, b, minus_result));
                    } else if (check == R.id.multiply) {
                        int multiply_result = a * b;
                        result.setText(String.format("%d * %d = %d", a, b, multiply_result));
                    } else if (check == R.id.division) {
                        if (a == 0 || b == 0) {
                            Toast.makeText(getBaseContext(),"0으로는 나눌 수 없습니다.",Toast.LENGTH_SHORT).show();
                        } else {
                            float division_result = (float) a / b;
                            result.setText(String.format("%d / %d = %.2f", a, b, division_result));
                        }
                    } else if (check == R.id.remainder){
                        if (a == 0 || b == 0) {
                            Toast.makeText(getBaseContext(),"0으로는 나눌 수 없습니다.",Toast.LENGTH_SHORT).show();
                        } else {
                            int remainder_result = a % b;
                            result.setText(String.format("%d %% %d = %d", a, b, remainder_result));
                        }
                    }
                }
            }
        };

        plus.setOnClickListener(onClickListener);
        minus.setOnClickListener(onClickListener);
        multiply.setOnClickListener(onClickListener);
        division.setOnClickListener(onClickListener);
        remainder.setOnClickListener(onClickListener);
    }
}