package com.example.finalterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class customList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list2);
        Button button = findViewById(R.id.back_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(customList.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // 데이터 불러오기
        String[] names = getResources().getStringArray(R.array.member);
        String[] jobs = getResources().getStringArray(R.array.job);
        String[] birthYears = getResources().getStringArray(R.array.birth);
        int[] imageResIds = { R.drawable.myimage, R.drawable.lee1, R.drawable.lee2, R.drawable.name2, R.drawable.name5, R.drawable.name6, R.drawable.lee1, R.drawable.lee2, R.drawable.name2, R.drawable.name5}; // 이미지 리소스 ID

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // 데이터 모델 리스트 생성
        List<Member2> members = new ArrayList<>();
        int minLength = Math.min(
                Math.min(names.length, jobs.length),
                Math.min(birthYears.length, imageResIds.length)
        );

        for (int i = 0; i < minLength; i++) {
            int age = currentYear - Integer.parseInt(birthYears[i]);
            members.add(new Member2(names[i], age, jobs[i], imageResIds[i]));
        }



        // 리스트뷰 설정
        ListView listView = findViewById(R.id.member_list_view);
        CustomArrayAdapter2 adapter = new CustomArrayAdapter2(this, members);
        listView.setAdapter(adapter);

        // 항목 클릭 이벤트 처리
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Member2 selectedMember = members.get(position);
            MemberDetailDialogFragment dialog = MemberDetailDialogFragment.newInstance(
                    selectedMember.getName(),
                    selectedMember.getAge(),
                    selectedMember.getJob(),
                    selectedMember.getImageResId()
            );
            dialog.show(getSupportFragmentManager(), "MemberDetailDialog");
        });
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
