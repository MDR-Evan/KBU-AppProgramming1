package com.example.week2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;


public class Report3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report3);

//      나이 -> 출생년도
        EditText age_editText = findViewById(R.id.age_editText);
        Button age_button = findViewById(R.id.age_button);
//      출생년도 -> 나이
        EditText year_editText = findViewById(R.id.year_editText);
        Button year_button = findViewById(R.id.year_button);

        age_button.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            @Override
            public void onClick(View view) {
                String input = age_editText.getText().toString();

                if (input.isEmpty()) {
                    Toast.makeText(getBaseContext(), "출생 년도를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (input.length() != 4 && Integer.parseInt(input) <= 0 || Integer.parseInt(input) > calendar.get(calendar.YEAR)){
                    Toast.makeText(getBaseContext(),"출생 년도 4자리를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    int trans_input = Integer.parseInt(input);
                    int year = calendar.get(calendar.YEAR);

                    Toast.makeText(getBaseContext(),String.format("당신의 나이는 %d세입니다.", year - trans_input + 1), Toast.LENGTH_SHORT).show();
                }
            }
        });

        year_button.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            @Override
            public void onClick(View view) {
                String input = year_editText.getText().toString();

                if (input.isEmpty()) {
                    Toast.makeText(getBaseContext(),"나이를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(input) <= 0 || Integer.parseInt(input) > 130){
                    Toast.makeText(getBaseContext(),"나이는 최대 130세 까지 입력 가능합니다.", Toast.LENGTH_SHORT).show();
                } else {
                    int T_year = calendar.get(calendar.YEAR);
                    int year = Integer.parseInt(input);

                    Toast.makeText(getBaseContext(),String.format("당신의 태어난 해는 %d년입니다.", T_year - year + 1), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}