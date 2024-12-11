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

public class SimpleList2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list2);

        // 데이터 로드
        String[] members = getResources().getStringArray(R.array.member);
        String[] births = getResources().getStringArray(R.array.birth);
        String[] jobs = getResources().getStringArray(R.array.job);

        // 현재 연도 가져오기
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // Member 객체 리스트 생성
        List<Member> memberList = new ArrayList<>();
        for (int i = 0; i < members.length; i++) {
            int age = currentYear - Integer.parseInt(births[i]);
            memberList.add(new Member(members[i], age, jobs[i]));
        }

        // CustomAdapter 설정
        ListView listView = findViewById(R.id.member_list_view);
        CustomAdapter adapter = new CustomAdapter(this, memberList);
        listView.setAdapter(adapter);

        // 항목 클릭 이벤트 처리
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Member selectedMember = memberList.get(position);
            Intent intent = new Intent(SimpleList2.this, SimpleList2DetailActivity.class);
            intent.putExtra("position", position + 1);
            intent.putExtra("name", selectedMember.getName());
            intent.putExtra("age", selectedMember.getAge());
            intent.putExtra("job", selectedMember.getJob());
            startActivity(intent);
        });

        Button button = findViewById(R.id.back_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SimpleList2.this, MainActivity.class);
                startActivity(intent);
            }
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
