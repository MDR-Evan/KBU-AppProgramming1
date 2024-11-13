package com.example.week11;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondFragment extends Fragment {
    private final Double Official = 3.305785;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText edit = view.findViewById(R.id.area_edit1);
        TextView text = view.findViewById(R.id.area_text1);
        Button button1 = view.findViewById(R.id.area_button1),
                button2 = view.findViewById(R.id.area_button2);

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
            Toast.makeText(getActivity(), "입력하세요", Toast.LENGTH_SHORT).show();
        } else {
            Double result = (double) (Math.round(Double.parseDouble(value) / Official * 100) / 100);
            text.setText(String.format("%.2f ㎡", value));
        }
    }

    private void changeToMeter(EditText edit, TextView text) {
        String value = edit.getText().toString();

        if (value.isEmpty()) {
            Toast.makeText(getActivity(), "입력하세요", Toast.LENGTH_SHORT).show();
        } else {
            Double result = Double.parseDouble(value) * Official;
            text.setText(String.format("%.2f ㎡", value));
        }
    }
}


