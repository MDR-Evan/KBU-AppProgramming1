package com.example.week9;

import static android.graphics.Color.RED;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> itemList;
    ArrayAdapter<String> listAdapter;

    CheckBox checkBox;
    LinearLayout linearLayout;
    TextView empty, result;
    Spinner schoolname, classname;
    EditText schoolname_edit, classname_edit, name;
    Button insert, delete;
    int id = 0, selectedPosition = -1, selected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empty = findViewById(R.id.empty);
        linearLayout = findViewById(R.id.notempty);
        ListView mainlist = findViewById(R.id.mainlist);

        checkBox = findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox.isChecked()) {
                    linearLayout.setVisibility(View.VISIBLE);
                    empty.setVisibility(View.INVISIBLE);
                    mainlist.setVisibility(View.INVISIBLE);
                } else {
                    linearLayout.setVisibility(View.INVISIBLE);
                    if (itemList.isEmpty()) {
                        empty.setVisibility(View.VISIBLE);
                        mainlist.setVisibility(View.INVISIBLE);
                    } else {
                        empty.setVisibility(View.INVISIBLE);
                        mainlist.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        schoolname = findViewById(R.id.schoolname_spinner);
        schoolname_edit = findViewById(R.id.schoolname_edit);

        String[] school_list = getResources().getStringArray(R.array.school);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, school_list) {
            @NonNull
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView textView = (TextView) view;
                if (position == 0) {
                    textView.setTextColor(Color.BLUE);
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        schoolname.setAdapter(adapter);
        schoolname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean first = false;

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (first) {
                    if (i != 0) {
                        String Text = (String) adapterView.getItemAtPosition(i);
                        schoolname_edit.setText(Text);
                    }
                } else {
                    first = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        classname = findViewById(R.id.classname_spinner);
        classname_edit = findViewById(R.id.classname_edit);
        result = findViewById(R.id.classname_result);


        String[] classname_list = getResources().getStringArray(R.array.classname);


        classname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("학과를 선택하세요");

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_singlechoice, classname_list) {
                        @NonNull
                        @Override
                        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                            View view = super.getView(position, convertView, parent);
                            TextView textView = (TextView) view;
                            textView.setTextColor(Color.WHITE);
                            view.setBackgroundColor(Color.BLUE);
                            return view;
                        }
                    };

                    builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String selectedClass = classname_list[which];
                            classname_edit.setText(selectedClass);
                            result.setText(selectedClass);
                            dialog.dismiss();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return true;
                }
                return false;
            }
        });

        RadioGroup group = findViewById(R.id.group);
        RadioButton grade1 = findViewById(R.id.first_grade);
        RadioButton grade2 = findViewById(R.id.second_grade);
        RadioButton grade3 = findViewById(R.id.third_grade);


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.first_grade) {
                    id = 1;
                } else if (checkedId == R.id.second_grade) {
                    id = 2;
                } else if (checkedId == R.id.third_grade) {
                    id = 3;
                }
            }
        });

        name = findViewById(R.id.name_edit);
        insert = findViewById(R.id.insert_button);
        delete = findViewById(R.id.delete_button);
        ListView result = findViewById(R.id.result_listview);

        itemList = new ArrayList<>();
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        result.setAdapter(listAdapter);
        mainlist.setAdapter(listAdapter);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String school = schoolname_edit.getText().toString().trim();
                String classname = classname_edit.getText().toString().trim();
                String gradeText = id + "학년";
                String nameText = name.getText().toString().trim();

                if (!school.isEmpty() && !classname.isEmpty() && id != 0 && !nameText.isEmpty()) {
                    String formattedText = String.format("%s %s %s %s", school, classname, gradeText, nameText);

                    itemList.add(formattedText);
                    listAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    String selectedItem = itemList.get(selectedPosition);

                    String del = "삭제";
                    SpannableString spannable = new SpannableString(del);
                    spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, del.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    String worning = selectedItem + "을(를) 정말로 " + del + "하시겠습니까?";

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setTitle("경고");
                    builder.setMessage(worning);
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            itemList.remove(selectedPosition); // 선택된 항목 삭제
                            listAdapter.notifyDataSetChanged(); // ListView 갱신
                            selectedPosition = -1; // 선택 상태 초기화
                            Toast.makeText(MainActivity.this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).show();
                } else {
                    String sel = "선택하세요";
                    SpannableString spannable = new SpannableString(sel);
                    spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, sel.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    Toast toast = Toast.makeText(MainActivity.this, spannable, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        TextView headerView = new TextView(this);
        headerView.setText("리스트의 시작입니다.");
        headerView.setBackgroundColor(Color.BLUE);
        headerView.setTextColor(Color.WHITE);
        headerView.setGravity(Gravity.CENTER);
        headerView.setTextSize(18);
        headerView.setPadding(0, 20, 0, 20);

        TextView footerView = new TextView(this);
        footerView.setText("로딩 중...");
        footerView.setBackgroundColor(Color.BLUE);
        footerView.setTextColor(Color.WHITE);
        footerView.setGravity(Gravity.CENTER);
        headerView.setTextSize(18);
        footerView.setPadding(0, 20, 0, 20);

        mainlist.addHeaderView(headerView);
        mainlist.addFooterView(footerView);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        mainlist.setAdapter(adapter1);

        mainlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int adjustedPosition = i - mainlist.getHeaderViewsCount();

                if (adjustedPosition >= 0 && adjustedPosition < itemList.size()) {
                    if (selected != -1) {
                        View previousView = mainlist.getChildAt(selected + mainlist.getHeaderViewsCount() - mainlist.getFirstVisiblePosition());
                        if (previousView != null) {
                            previousView.setBackgroundColor(Color.TRANSPARENT);
                        }
                    }

                    selected = adjustedPosition;
                    view.setBackgroundColor(Color.rgb(255, 87, 34));

                    String selectedItem = itemList.get(adjustedPosition);

                    Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
