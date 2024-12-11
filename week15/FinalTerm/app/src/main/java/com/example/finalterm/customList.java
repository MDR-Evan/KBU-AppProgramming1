package com.example.finalterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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


        // 데이터 불러오기
        String[] names = getResources().getStringArray(R.array.member);
        String[] jobs = getResources().getStringArray(R.array.job);
        String[] birthYears = getResources().getStringArray(R.array.birth);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // 데이터 모델 리스트 생성
        List<Member2> members = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            int age = currentYear - Integer.parseInt(birthYears[i]);
            members.add(new Member2(names[i], age, jobs[i], R.drawable.ic_launcher));
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
