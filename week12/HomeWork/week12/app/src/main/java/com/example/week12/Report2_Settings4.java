package com.example.week12;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.preference.PreferenceManager;

import org.jetbrains.annotations.Nullable;

public class Report2_Settings4 extends PreferenceActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.report2_settings4);

        setContentView(R.layout.report2_admin);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if ("admin".equals(preference.getKey())) {
            admin();
            return true;
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    private void admin() {
        View view = getLayoutInflater().inflate(R.layout.report2_admin, null);

        // AlertDialog를 생성해 레이아웃을 다이얼로그로 출력
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view); // admin 레이아웃 설정
        builder.setTitle("Admin Settings"); // 다이얼로그 제목
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // 다이얼로그 닫기
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // 다이얼로그 닫기
            }
        });

        // 다이얼로그 표시
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
