package com.example.tab;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstActivity extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            view = inflater.inflate(R.layout.fragment_first_activity, container, false);

        EditText bmi_edit1 = view.findViewById(R.id.bmi_edit1);
        EditText bmi_edit2 = view.findViewById(R.id.bmi_edit2);
        TextView bmi_text1 = view.findViewById(R.id.bmi_text1);
        Button bmi_button1 = view.findViewById(R.id.bmi_button1);

        bmi_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bmiCheck(bmi_edit1, bmi_edit2, bmi_text1);
            }
        });

        return view;
    }

    private void bmiCheck(EditText bmiEdit1, EditText bmiEdit2, TextView bmiText1) {
        String height = bmiEdit1.getText().toString();
        String weight = bmiEdit2.getText().toString();
        if (height.isEmpty() || weight.isEmpty()) {
            Toast.makeText(getActivity(), "자료 입력 해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            double test_height = Double.parseDouble(height);
            double test_weight = Double.parseDouble(weight);

            double result = test_weight / (test_height / 100) + (test_height / 100);
            if (result < 18.5) {
                bmiText1.setText(String.format("BMI : %.2f, %s", result, "!!체중부족!!"));
            } else if (result < 22.9) {
                bmiText1.setText(String.format("BMI : %.2f, %s", result, "!~정상~!"));
            } else if (result < 24.9) {
                bmiText1.setText(String.format("BMI : %.2f, %s", result, "!!과체중!!"));
            } else if (result > 25) {
                bmiText1.setText(String.format("BMI : %.2f, %s", result, "!!!비만!!!"));
            }
        }
    }
}