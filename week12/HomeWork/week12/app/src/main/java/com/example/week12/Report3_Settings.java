package com.example.week12;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.preference.ListPreference;

public class Report3_Settings extends PreferenceActivity {
    private SharedPreferences preferences;
    private LinearLayout layout;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.report3_settings);

        preferences = getSharedPreferences("USERID", MODE_PRIVATE);

/*        // 초기 설정 적용
        applyPreferences();*/

        // 이름 입력 Preference 클릭 리스너
        Preference namePreference = findPreference("Input_name");
        if (namePreference != null) {
            namePreference.setOnPreferenceClickListener(preference -> {
                showInputDialog();
                return true;
            });
        }

/*        // 변경 버튼 클릭 이벤트
        change();*/
    }

   /* // SharedPreferences에서 값을 가져와 UI에 적용
    private void applyPreferences() {
        textView = findViewById(R.id.Report3_text);
        layout = findViewById(R.id.main);

        // SharedPreferences 값 가져오기
        String name = preferences.getString("Input_name", "기본 이름");
        String colorText = preferences.getString("TextColor", "#000000"); // 기본값 검정
        boolean bold = preferences.getBoolean("boldText", false);
        String colorBg = preferences.getString("ScreenColor", "#FFFFFF"); // 기본값 흰색

        try {
            // TextView 값 및 스타일 적용
            textView.setText(name);
            textView.setTextColor(Color.parseColor(colorText)); // 텍스트 색상
            textView.setTypeface(null, bold ? Typeface.BOLD : Typeface.NORMAL); // 텍스트 스타일

            // LinearLayout 배경 색상 적용
            layout.setBackgroundColor(Color.parseColor(colorBg));
        } catch (IllegalArgumentException e) {
            Toast.makeText(this, "잘못된 색상 값입니다. #RRGGBB 형식으로 입력하세요.", Toast.LENGTH_SHORT).show();
        }
    }

    // 변경 버튼 클릭 이벤트 처리
    private void change() {
        button = findViewById(R.id.Report3_button);

        button.setOnClickListener(view -> {
            // SharedPreferences 값으로 UI 업데이트
            applyPreferences();
        });
    }*/


    private void showInputDialog() {
        View dialogView = LayoutInflater.from(this).inflate(R.layout.activity_report3_inputname, null);
        EditText editText = dialogView.findViewById(R.id.Report3_Edit);

        String name = editText.getText().toString().trim();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Input_name", name);
        editor.apply();
    }
}
