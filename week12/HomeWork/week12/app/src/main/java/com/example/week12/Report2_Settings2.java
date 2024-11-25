package com.example.week12;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.preference.PreferenceManager;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Report2_Settings2 extends PreferenceActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.report2_settings2);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if ("Rington".equals(preference.getKey())) {
            showRingtonDialog();
            return true;
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    private void showRingtonDialog() {
        String[] ringtonOptions = getResources().getStringArray(R.array.Rington_entries);
        final String[] ringtonValues = getResources().getStringArray(R.array.Rington_values);

        String savedRingtonValue = sharedPreferences.getString("selected_rington", ringtonValues[0]);
        int selectedIndex = 0;
        for (int i = 0; i < ringtonValues.length; i++) {
            if (ringtonValues[i].equals(savedRingtonValue)) {
                selectedIndex = i;
                break;
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Alarm")
               .setSingleChoiceItems(ringtonOptions, selectedIndex, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       SharedPreferences.Editor editor = sharedPreferences.edit();
                       editor.putString("selected_rington", ringtonValues[which]);
                       editor.apply();
                   }
               })
               .setPositiveButton("OK", null)
               .setNegativeButton("CANCEL", null);
        builder.create().show();
    }
}