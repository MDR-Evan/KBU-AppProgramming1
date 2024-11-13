package com.example.week11;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        TabHost host = getTabHost();
//      1번 - BMI 계산기
        TabHost.TabSpec tab1 = host.newTabSpec("BMI")
                                   .setIndicator("BMI 계산기")
                                   .setContent(new Intent(this, BMIActivity.class));
        host.addTab(tab1);
//      2번 - 면적 계산기
        TabHost.TabSpec tab2 = host.newTabSpec("면적")
                                   .setIndicator("면적 계산기")
                                   .setContent(new Intent(this, AreaActivity.class));
        host.addTab(tab2);
//      3번 - Naver 접속
        TabHost.TabSpec tab3 = host.newTabSpec("NAVER")
                                   .setIndicator("NAVER")
                                   .setContent(new Intent(this, NaverActivity.class));
        host.addTab(tab3);
    }
}