package com.example.adapterview;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<String> arrayList, arrayList1;
    ArrayAdapter<String> adapter, spiinneradapter;
    int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = findViewById(R.id.textview);
        ListView listView = findViewById(R.id.listview);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setDividerHeight(3);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity2.this, arrayList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder.setTitle("경고");
                builder.setMessage(arrayList.get(i) + "를 삭제하시겠습니까?");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrayList.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create();
                builder.show();

                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String area[] = null;
        Spinner spinner = findViewById(R.id.spinner);

        if (type == 1) {
            area = new String[] {"분야를 선택하세요", "Visual Basic", "Python"};
        } else if (type == 2) {
            area = getResources().getStringArray(R.array.area);
        } else {
            arrayList1.add("분야를 선택하세요");
            arrayList1.add("미술");
            arrayList1.add("음악");
        }

        if (type == 1 || type == 2) {
            spiinneradapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area) {
                @Override
                public boolean isEnabled(int position) {
                    return super.isEnabled(position);
                }

                @Override
                public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                    return super.getDropDownView(position, convertView, parent);
                }
            };
        } else {
            spiinneradapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList1) {
                @Override
                public boolean isEnabled(int position) {
                    if (position == 0) {
                        return false;
                    } else {
                        return true;
                    }
                }

                @Override
                public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView textView = (TextView) view;

                    if (position == 0) {
                        textView.setTextColor(Color.RED);
                    } else {
                        textView.setTextColor(Color.BLUE);
                    }

                    return view;
                }
            };

            spiinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spiinneradapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                boolean first = false;

                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView textView = (TextView) view;
                    textView.setTextColor(Color.BLUE);

                    if (first) {

                    } else {
                        first = true;
                    }
                    arrayList.add(spiinneradapter.getItem(i));
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int check = item.getItemId();

        if (check == R.id.test1) {
            type = 1;
        } else if (check == R.id.test2) {
            type = 2;
        } else {
            type = 3;
        }

        onResume();
        item.setChecked(true);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);

        return true;
    }
}