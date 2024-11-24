package com.example.week12;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;

import androidx.annotation.Nullable;

public class Report2_Settings1 extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.report2_settings1);

        PreferenceScreen screen = getPreferenceScreen();
    }
}