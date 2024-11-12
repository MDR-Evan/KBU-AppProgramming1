package com.example.tab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        FragmentManager manager = getSupportFragmentManager();
        MyPagerAdapter adapter = new MyPagerAdapter(manager);
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(adapter);

        View.OnClickListener pageListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tag = (int) view.getTag();
                pager.setCurrentItem(tag);
            }
        };

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setTag(0);
        button2.setTag(1);
        button3.setTag(2);

        button1.setOnClickListener(pageListener);
        button2.setOnClickListener(pageListener);
        button3.setOnClickListener(pageListener);
    }
}