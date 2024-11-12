package com.example.tab;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout1, layout2;
    FrameLayout frameLayout;
    WebView webView;
    private final double Official = 3.305785;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = findViewById(R.id.tab1);
        layout2 = findViewById(R.id.tab2);
        frameLayout = findViewById(R.id.framelayout);
        webView = findViewById(R.id.webview);

        Button button = findViewById(R.id.button1);
        button.performClick();
    }


    public void buttonOnclicked(View view) {
        int check = view.getId();

        if (check == R.id.button1) {
            changeView(0, "#fff32f");
            EditText bmi_edit1 = findViewById(R.id.bmi_edit1);
            EditText bmi_edit2 = findViewById(R.id.bmi_edit2);
            TextView bmi_text1 = findViewById(R.id.bmi_text1);
            Button bmi_button1 = findViewById(R.id.bmi_button1);

            bmi_button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bmiCheck(bmi_edit1, bmi_edit2, bmi_text1);
                }
            });
        } else if (check == R.id.button2) {
            changeView(1, "#2FFF8D");
            EditText area_edit1 = findViewById(R.id.area_edit1);
            TextView area_text1 = findViewById(R.id.area_text1);
            Button area_button1 = findViewById(R.id.area_button1);
            Button area_button2 = findViewById(R.id.area_button2);

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
            changeView(2, "#fff32f");
            webloading();
        }
    }

    private void ChangeToPyung(EditText areaEdit1, TextView areaText1) {
        String value = areaEdit1.getText().toString();
        if (value.equals("")) {
            Toast.makeText(this, "자료 압력 해주세요", Toast.LENGTH_SHORT).show();
        } else {
            double result = Math.round(Double.parseDouble(value) / Official * 100 / 100);
            areaText1.setText(String.format("%,.2f 평", result));
        }
    }

    private void ChangeToMeter(EditText areaEdit1, TextView areaText1) {
        String value = areaEdit1.getText().toString();
        if (value.equals("")) {
            Toast.makeText(this, "자료 압력 해주세요", Toast.LENGTH_SHORT).show();
        } else {
            double result = Double.parseDouble(value) * Official;
            areaText1.setText(String.format("%,.2f ㎡", result));
        }
    }

    private void bmiCheck(EditText bmiEdit1, EditText bmiEdit2, TextView bmiText1) {
        String height = bmiEdit1.getText().toString();
        String weight = bmiEdit2.getText().toString();
        if (height.isEmpty() || weight.isEmpty()) {
            Toast.makeText(this, "자료 입력 해주세요.", Toast.LENGTH_SHORT).show();
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

    private void webloading() {
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://m.naver.com");

    }

    private void changeView(int i, String hashtag) {
        layout1.setVisibility(i == 0 ? View.VISIBLE : View.INVISIBLE);
        layout2.setVisibility(i == 1 ? View.VISIBLE : View.INVISIBLE);
        webView.setVisibility(i == 2 ? View.VISIBLE : View.INVISIBLE);
    }
}