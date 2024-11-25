package com.example.week12;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;

import org.jetbrains.annotations.Nullable;

public class Report2_Settings3 extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.report2_settings3);
    }
}
