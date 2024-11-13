package com.example.week11;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TabLayout tab = findViewById(R.id.M3_tab1);
        ViewPager2 pager2 = findViewById(R.id.M3_pager);

        TabPagerAdapter adapter = new TabPagerAdapter(MainActivity3.this);
        pager2.setAdapter(adapter);
        TabLayoutMediator mediator = new TabLayoutMediator(tab, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("BMI 계산기");
                        break;
                    case 1:
                        tab.setText("면적 계산기");
                        break;
                    case 2:
                        tab.setText("NAVER");
                }
            }
        });
        mediator.attach();
    }
}