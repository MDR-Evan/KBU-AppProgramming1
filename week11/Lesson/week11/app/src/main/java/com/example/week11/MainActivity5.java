package com.example.week11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTabHost;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTabHost host = findViewById(android.R.id.tabhost);
        host.setup(this, manager, android.R.id.tabcontent);

        //      1번 - BMI 계산기
        TabHost.TabSpec tab1 = host.newTabSpec("BMI")
                                   .setIndicator("BMI 계산기",  null);
        host.addTab(tab1, FirstFragment.class, null);

        //      2번 - 면적 계산기
        TabHost.TabSpec tab2 = host.newTabSpec("면적")
                                   .setIndicator("면적 계산기",  null);
        host.addTab(tab2, SecondFragment.class, null);

        //      3번 - Naver 접속
        TabHost.TabSpec tab3 = host.newTabSpec("NAVER")
                                   .setIndicator("NAVER", null);
        host.addTab(tab3, ThirdFragment.class, null);
    }
}