package com.example.week12;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class Report3_Settings extends PreferenceActivity {
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.report3_settings);
        preferences = getSharedPreferences("USERID", MODE_PRIVATE);

        Preference namePreference = findPreference("Input_name");
        if (namePreference != null) {
            namePreference.setOnPreferenceClickListener(preference -> {
                showInputDialog();
                return true;
            });
        }
    }

    private void showInputDialog() {
        View dialogView = LayoutInflater.from(this).inflate(R.layout.activity_report3_inputname, null);
        EditText editText = dialogView.findViewById(R.id.Report3_Edit);
        String name = editText.getText().toString().trim();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", name);
        editor.apply();
    }
}
