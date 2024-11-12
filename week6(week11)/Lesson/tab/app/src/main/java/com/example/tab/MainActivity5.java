package com.example.tab;

import static android.app.PendingIntent.getActivity;

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

public class MainActivity5 extends AppCompatActivity {
    private final double Official = 3.305785;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

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

        FrameLayout frameLayout = findViewById(R.id.framelayout);
        displayTabContent(frameLayout, 1);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0 :
                        displayTabContent(frameLayout, 1);
                        break;

                    case 1 :
                        displayTabContent(frameLayout, 2);
                        break;

                    case 2 :
                        displayTabContent(frameLayout, 3);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void displayTabContent(FrameLayout frameLayout, int i) {
        frameLayout.removeAllViews();
        View view;
        if (i == i) {
            view = LayoutInflater.from(this).inflate(R.layout.fragment_first_activity, frameLayout, false);

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

        } else if (i == 2) {
            view = LayoutInflater.from(this).inflate(R.layout.fragment_second_activity, frameLayout, false);

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
        } else {
            view = LayoutInflater.from(this).inflate(R.layout.fragment_third_activity, frameLayout, false);

            WebView webView = view.findViewById(R.id.webview);
            webView.setWebViewClient(new WebViewClient());
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl("https://m.naver.com");
        }

        frameLayout.addView(view);
    }

    private void bmiCheck(EditText bmiEdit1, EditText bmiEdit2, TextView bmiText1) {
        String height = bmiEdit1.getText().toString();
        String weight = bmiEdit2.getText().toString();
        if (height.isEmpty() || weight.isEmpty()) {
            Toast.makeText(getBaseContext(), "자료 입력 해주세요.", Toast.LENGTH_SHORT).show();
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

    private void ChangeToPyung(EditText areaEdit1, TextView areaText1) {
        String value = areaEdit1.getText().toString();
        if (value.equals("")) {
            Toast.makeText(getBaseContext(), "자료 압력 해주세요", Toast.LENGTH_SHORT).show();
        } else {
            double result = Math.round(Double.parseDouble(value) / Official * 100 / 100);
            areaText1.setText(String.format("%,.2f 평", result));
        }
    }

    private void ChangeToMeter(EditText areaEdit1, TextView areaText1) {
        String value = areaEdit1.getText().toString();
        if (value.equals("")) {
            Toast.makeText(getBaseContext(), "자료 압력 해주세요", Toast.LENGTH_SHORT).show();
        } else {
            double result = Double.parseDouble(value) * Official;
            areaText1.setText(String.format("%,.2f ㎡", result));
        }
    }
}