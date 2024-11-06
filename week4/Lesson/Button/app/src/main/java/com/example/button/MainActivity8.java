package com.example.button;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        EditText editText = findViewById(R.id.editText);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        RadioGroup group1 = findViewById(R.id.radioGroup1);
        RadioGroup group2 = findViewById(R.id.radioGroup2);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = editText.getText().toString();
                if (value.isEmpty()) {
                    Toast.makeText(getBaseContext(), "입력해주세요.",Toast.LENGTH_SHORT).show();
                } else {
                    int price = Integer.parseInt(value);
                    int pay = 0;
                    int check = group1.getCheckedRadioButtonId();
                    if (check == R.id.radio1_1) {
                        pay = (int) (price / 1.1f);
                    } else if (check == R.id.radio1_2){
                        pay = (int) (price / 1.1f + 0.5f);
                    } else if (check == R.id.radio1_3) {
                        pay = (int) (price / 1.1f + 0.9f);
                    }

                    check = group2.getCheckedRadioButtonId();
                    if (check == R.id.radio2_1) {
                        pay += 5;
                        pay = (int) (pay / 10.0f);
                        pay *= 10;
                    }
                    int tax = price - pay;
                    textView1.setText(String.format("가격 : %,d 원\n",pay));
                    textView2.setText(String.format("세금 : %,d 원\n",tax));
                }
            }
        });
    }
}