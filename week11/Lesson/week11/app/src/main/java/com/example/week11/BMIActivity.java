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

public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);

        EditText editText1 = findViewById(R.id.bmi_edit1),
                 editText2 = findViewById(R.id.bmi_edit2);
        TextView textView1 = findViewById(R.id.bmi_text1);
        Button button1 = findViewById(R.id.bmi_button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String I_height = editText1.getText().toString(),
                       I_weight = editText2.getText().toString();

                if (I_height.isEmpty() || I_weight.isEmpty()) {
                    Toast.makeText(getBaseContext(), "입력해 주세요", Toast.LENGTH_SHORT).show();
                } else {
                    double height = Double.parseDouble(I_height),
                            weight = Double.parseDouble(I_weight),
                            bmi = weight / ((height / 100) * (height / 100));

                    if (bmi < 18.5) {
                        textView1.setText(String.format("BMI 지수 : %.2f, %s", bmi, "! 저체중 !"));
                    } else if (bmi < 22.9) {
                        textView1.setText(String.format("BMI 지수 : %.2f, %s", bmi, "정상"));
                    } else if (bmi < 24.9) {
                        textView1.setText(String.format("BMI 지수 : %.2f, %s", bmi, "!! 과체중 !!"));
                    }else if (25 < bmi) {
                        textView1.setText(String.format("BMI 지수 : %.2f, %s", bmi, "!!! 비만 !!!"));
                    }
                }
            }
        });
    }
}