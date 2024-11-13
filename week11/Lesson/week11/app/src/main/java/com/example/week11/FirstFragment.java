package com.example.week11;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText1 = view.findViewById(R.id.bmi_edit1),
                editText2 = view.findViewById(R.id.bmi_edit2);
        TextView textView1 = view.findViewById(R.id.bmi_text1);
        Button button1 = view.findViewById(R.id.bmi_button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String I_height = editText1.getText().toString(),
                        I_weight = editText2.getText().toString();

                if (I_height.isEmpty() || I_weight.isEmpty()) {
                    Toast.makeText(getActivity(), "입력해 주세요", Toast.LENGTH_SHORT).show();
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