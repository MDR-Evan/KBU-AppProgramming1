package com.example.week11;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Report1 extends AppCompatActivity {
    LinearLayout layout1, layout2;
    boolean flag = true;
    ViewPager2 pager2;
    Button button;
    private FragmentStateAdapter pagerAdapter;

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

        button = findViewById(R.id.btnToggle);
        pager2 = findViewById(R.id.viewPager2);
        pagerAdapter = new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return 6;
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0:
                        return new FirstFragment();
                    case 1:
                        return new SecondFragment();
                    case 2:
                        return new ThirdFragment();
                    case 3:
                        return new FourthFragment();
                    case 4:
                        return new FifthFragment();
                    case 5:
                        return new sixthFragment();
                    default:
                        return null;
                }
            }
        };
        pager2.setAdapter(pagerAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    button.setText("세로로 슬라이드");
                    pager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
                    flag = false;

                } else {
                    button.setText("가로로 슬라이드");
                    pager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                    flag = true;
                }
            }
        });
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