/*
package com.example.week11;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Report2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);

        TabLayout tab = findViewById(R.id.R2_tab1);
        ViewPager2 pager2 = findViewById(R.id.R2_pager);

        TabPagerAdapter adapter = new TabPagerAdapter(Report2.this);
        pager2.setAdapter(adapter);
        TabLayoutMediator mediator = new TabLayoutMediator(tab, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.item1);
        menuItem.setChecked(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int check = item.getItemId();
        if (check == 0) {
            item.setChecked(true);
            Slide();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}*/
