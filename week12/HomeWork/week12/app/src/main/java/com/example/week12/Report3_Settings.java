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

        // Preference XML 로드
        addPreferencesFromResource(R.xml.report3_settings);

        // SharedPreferences 초기화
        preferences = getSharedPreferences("USERID", MODE_PRIVATE);

        // Input_name Preference 클릭 이벤트 설정
        Preference namePreference = findPreference("Input_name");
        if (namePreference != null) {
            namePreference.setOnPreferenceClickListener(preference -> {
                showInputDialog();
                return true;
            });
        }
    }

    // 이름 입력 다이얼로그
    private void showInputDialog() {
        // 다이얼로그 뷰 생성
        View dialogView = LayoutInflater.from(this).inflate(R.layout.activity_report3_inputname, null);
        EditText editText = dialogView.findViewById(R.id.Report3_Edit);

        // 다이얼로그 설정
        new AlertDialog.Builder(this)
                .setTitle("이름 입력")
                .setView(dialogView)
                .setPositiveButton("확인", (dialog, which) -> {
                    String name = editText.getText().toString().trim();
                    if (name.isEmpty()) {
                        Toast.makeText(this, "이름을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    } else {
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("name", name);
                        editor.apply();
                        Toast.makeText(this, "이름이 저장되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("취소", (dialog, which) -> {
                    Toast.makeText(this, "취소되었습니다.", Toast.LENGTH_SHORT).show();
                })
                .create()
                .show();
    }
}
