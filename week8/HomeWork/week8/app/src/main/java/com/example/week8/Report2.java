package com.example.week8;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Report2 extends AppCompatActivity {
    ListView listView;
    int type = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);
        
        listView = findViewById(R.id.report2_list);
        display(0);
    }

    private void display(int i) {
        if(i == 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("일요일(SUN)");
            arrayList.add("월요일(MON)");
            arrayList.add("화요일(TUE)");
            arrayList.add("수요일(WED)");
            arrayList.add("목요일(THU)");
            arrayList.add("금요일(FRI)");
            arrayList.add("토요일(SAT)");
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, arrayList);
            listView.setAdapter(adapter);
        }else if (i == 1) {
            String[] list = getResources().getStringArray(R.array.days1);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
        } else if (i == 2) {
            String[] list;
            list = new String[] {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
        } else if (i == 3) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.days2, android.R.layout.simple_list_item_1);

            listView.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.report2_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.menu1);
        menuItem.setChecked(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int check = item.getItemId();

        if (check == R.id.menu1) {
            display(0);
        } else if (check == R.id.menu2)
            display(1);
        else if (check == R.id.menu3)
            display(2);
        else
            display(3);

        item.setChecked(true);
        return true;
    }
}