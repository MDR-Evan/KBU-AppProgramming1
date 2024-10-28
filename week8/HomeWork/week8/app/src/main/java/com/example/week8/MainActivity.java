package com.example.week8;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items = new ArrayList<>();
    ArrayAdapter<String> adapter;
    Button button;
    ArrayList<Boolean> select = new ArrayList<>();
    int type = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        items.add("사과");
        items.add("배");
        items.add("귤");
        items.add("바나나");
        items.add("복숭아");
        items.add("수박");
        for (int i = 0; i < items.size(); i++) {
            select.add(false);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, items);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setOnItemClickListener(itemClickListener);

        TextView empty = findViewById(R.id.empty);
        listView.setEmptyView(empty);


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        StringBuilder selectedItems = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            if (select.get(i)) {
                selectedItems.append(items.get(i)).append("\n\n");
            }
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("선택한 과일 목록");

        if (selectedItems.length() > 0) {
            dialog.setMessage(selectedItems.toString().trim());
        } else {
            dialog.setMessage("선택된 항목이 없습니다.");
        }

        dialog.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int count = 0;

                for (int j = select.size() - 1; j >= 0; j--) {
                    if (select.get(j)) {
                        items.remove(j);
                        select.remove(j);
                        count++;
                    }
                }
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), String.format("%d개 삭제하였습니다.", count), Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(), "확인하였습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            select.set(i, !select.get(i));
            String selected = items.get(i);
            Toast.makeText(getBaseContext(), selected, Toast.LENGTH_SHORT).show();
        }
    };

    @SuppressLint("ResourceType")
    @Override
    protected void onResume() {
        super.onResume();

        if (type == 1) {
            for (int i = 0; i < select.size(); i++) {
                select.set(i, true);
            }

            ListView listView = findViewById(R.id.list);
            for (int i = 0; i < items.size(); i++) {
                listView.setItemChecked(i, true);
            }
        } else if (type == 2) {
            for (int i = 0; i < select.size(); i++) {
                select.set(i, false);
            }

            ListView listView = findViewById(R.id.list);
            for (int i = 0; i < items.size(); i++) {
                listView.setItemChecked(i, false);
            }
        } else if (type == 3) {
            AlertDialog.Builder inputdialog = new AlertDialog.Builder(this);

            LayoutInflater inflater = LayoutInflater.from(this);
            View dialogView = inflater.inflate(R.layout.report1_input, null);
            inputdialog.setView(dialogView);

            TextView title = dialogView.findViewById(R.id.title);
            EditText input = dialogView.findViewById(R.id.input);

            inputdialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String newItem = input.getText().toString().trim();

                    if (!newItem.isEmpty()) {
                        items.add(newItem);
                        select.add(false);
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getBaseContext(), "항목을 입력하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            AlertDialog dialog = inputdialog.create();
            dialog.show();
        } else if (type == 4) {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.report1_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int check = item.getItemId();

        if(check == R.id.item1) {
            type = 1;
        } else if (check == R.id.item2) {
            type = 2;
        } else if (check == R.id.item3) {
            type = 3;
        } else if (check == R.id.item4) {
            type = 4;
        }

        onResume();
        item.setChecked(true);
        return true;
    }
}
