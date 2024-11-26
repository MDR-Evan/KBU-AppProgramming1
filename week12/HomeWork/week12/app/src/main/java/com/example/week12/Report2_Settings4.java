package com.example.week12;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import androidx.preference.PreferenceManager;
import org.jetbrains.annotations.Nullable;

public class Report2_Settings4 extends PreferenceActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.report2_settings4);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Preference adminPreference = findPreference("admin");
        if (adminPreference != null) {
            adminPreference.setOnPreferenceClickListener(preference -> {
                Intent intent = new Intent(Report2_Settings4.this, Report2_admin.class);
                startActivity(intent);
                return true;
            });
        }
    }
}
