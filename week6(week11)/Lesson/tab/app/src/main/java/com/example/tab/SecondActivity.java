package com.example.tab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Fragment {
    private View view;
    private final double Official = 3.305785;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_second_activity, container, false);

        EditText area_edit1 = view.findViewById(R.id.area_edit1);
        TextView area_text1 = view.findViewById(R.id.area_text1);
        Button area_button1 = view.findViewById(R.id.area_button1);
        Button area_button2 = view.findViewById(R.id.area_button2);

        area_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeToMeter(area_edit1, area_text1);
            }
        });

        area_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeToPyung(area_edit1, area_text1);
            }
        });


        return view;
    }

    private void ChangeToPyung(EditText areaEdit1, TextView areaText1) {
        String value = areaEdit1.getText().toString();
        if (value.equals("")) {
            Toast.makeText(getActivity(), "자료 압력 해주세요", Toast.LENGTH_SHORT).show();
        } else {
            double result = Math.round(Double.parseDouble(value) / Official * 100 / 100);
            areaText1.setText(String.format("%,.2f 평", result));
        }
    }

    private void ChangeToMeter(EditText areaEdit1, TextView areaText1) {
        String value = areaEdit1.getText().toString();
        if (value.equals("")) {
            Toast.makeText(getActivity(), "자료 압력 해주세요", Toast.LENGTH_SHORT).show();
        } else {
            double result = Double.parseDouble(value) * Official;
            areaText1.setText(String.format("%,.2f ㎡", result));
        }
    }
}