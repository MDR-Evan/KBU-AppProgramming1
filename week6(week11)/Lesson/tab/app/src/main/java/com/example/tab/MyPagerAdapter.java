package com.example.tab;

import android.support.v4.app.INotificationSideChannel;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
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
    public int getCount() {
        return 3;
    }
}
