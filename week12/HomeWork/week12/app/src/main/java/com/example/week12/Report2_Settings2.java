package com.example.week12;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;

import org.jetbrains.annotations.Nullable;

public class Report2_Settings2 extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.report2_settings2);

        PreferenceScreen screen = getPreferenceScreen();

        ListPreference listPreference = (ListPreference) findPreference("AlertSound");

        if (listPreference != null) {
            listPreference.setSummary(listPreference.getEntry());

            listPreference.setOnPreferenceChangeListener((preference, newValue) -> {
                int index = listPreference.findIndexOfValue(newValue.toString());
                listPreference.setSummary(index >= 0 ? listPreference.getEntries()[index] : null);
                return true;
            });
        }
    }

    private void setPreferenceSummary(ListPreference listPreference, String value) {
        int index = listPreference.findIndexOfValue(value);

        if (index >= 0) {
            listPreference.setSummary(listPreference.getEntries()[index]);
        } else {
            listPreference.setSummary(null);
        }
    }
}