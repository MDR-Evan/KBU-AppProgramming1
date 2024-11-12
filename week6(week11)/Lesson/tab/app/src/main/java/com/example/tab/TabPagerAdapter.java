package com.example.tab;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0 :
                return new FirstActivity();

            case 1 :
                return new SecondActivity();

            case 2 :
                return new ThirdActivity();

            default :
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
