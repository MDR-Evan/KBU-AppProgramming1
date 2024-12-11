package com.example.finalterm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SimpleList2DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list2_fragment);

        TextView tvNumber = findViewById(R.id.tv_detail_number);
        TextView tvName = findViewById(R.id.tv_detail_name);
        TextView tvJob = findViewById(R.id.tv_detail_job);

        // Intent에서 데이터 가져오기
        int position = getIntent().getIntExtra("position", -1);
        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", -1);
        String job = getIntent().getStringExtra("job");

        // SpannableString으로 나이 부분만 빨간색으로 설정
        String fullText = name + " (" + age + "세)";
        SpannableString spannableName = new SpannableString(fullText);
        int ageStart = fullText.indexOf(String.valueOf(age)); // 나이 시작 위치
        int ageEnd = ageStart + String.valueOf(age).length(); // 나이 끝 위치
        spannableName.setSpan(new ForegroundColorSpan(Color.RED), ageStart, ageEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // 데이터 설정
        tvNumber.setText(position + "번째");
        tvName.setText(spannableName);
        tvJob.setText(job);

        // "돌아가기" 버튼 이벤트
        findViewById(R.id.back_button).setOnClickListener(v -> finish());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        int check = item.getItemId();

        if (check == R.id.menu) {
            intent = new Intent(getBaseContext(), Preference.class);
        }

        startActivity(intent);
        item.setChecked(true);
        return true;
    }
}
