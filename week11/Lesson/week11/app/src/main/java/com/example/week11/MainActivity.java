package com.example.week11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private final Double Official = 3.305785;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        TabLayout.Tab tab1 = tabLayout.newTab();
        tab1.setText("BMI 계산기");
        tabLayout.addTab(tab1);

        TabLayout.Tab tab2 = tabLayout.newTab();
        tab2.setText("면적 계산기");
        tabLayout.addTab(tab2);

        TabLayout.Tab tab3 = tabLayout.newTab();
        tab3.setText("NAVER");
        tabLayout.addTab(tab3);

        displayTabContents(0);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                displayTabContents(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void displayTabContents(int position) {
        View view = null;
        FrameLayout frameLayout = findViewById(R.id.frameLayout);

        frameLayout.removeAllViews();

        if (position == 0) {
            view = LayoutInflater.from(this).inflate(R.layout.fragment_first, frameLayout, false);

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
        } else if (position == 1) {
            view = LayoutInflater.from(this).inflate(R.layout.fragment_second, frameLayout, false);

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
        } else {
            view = LayoutInflater.from(this).inflate(R.layout.fragment_third, frameLayout, false);

            WebView web = view.findViewById(R.id.naver_web1);
            web.setWebViewClient(new WebViewClient());
            WebSettings settings = web.getSettings();
            settings.setJavaScriptEnabled(true);
            web.loadUrl("Https://m.naver.com");
        }
        frameLayout.addView(view);
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