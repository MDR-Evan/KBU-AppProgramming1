package com.example.week11;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Report1 extends AppCompatActivity {
    LinearLayout layout1, layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);

        TabLayout tab = findViewById(R.id.tabLayout);
        ViewPager2 pager = findViewById(R.id.viewPager);

        TabPagerAdapter adapter = new TabPagerAdapter(Report1.this);
        pager.setAdapter(adapter);
        TabLayoutMediator mediator = new TabLayoutMediator(tab, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setIcon(R.drawable.ic_face_black_36dp);
                        tab.setText("HOME");
                        break;
                    case 1:
                        tab.setIcon(R.drawable.ic_chat_bubble_outline_black_24dp);
                        tab.setText("CHATTING");
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ic_chrome_reader_mode_black_36dp);
                        tab.setText("NEWS") ;
                        break;
                    case 3:
                        tab.setIcon(R.drawable.ic_brightness_high_black_24dp);
                        tab.setText("SETTING");
                        break;
                }
            }
        });
        mediator.attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        layout1 = findViewById(R.id.first);
        layout2 = findViewById(R.id.second);

        boolean isChecked = !item.isChecked();
        item.setChecked(isChecked);

        if (isChecked) {
            layout1.setVisibility(View.INVISIBLE);
            layout2.setVisibility(View.VISIBLE);
        } else {
            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.INVISIBLE);
        }
        return true;
    }
}