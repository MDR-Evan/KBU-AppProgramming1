package com.example.week7;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Report2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);
    }

    public void showDialog1(View view) {
        AlertDialog.Builder dialog1 = new AlertDialog.Builder(Report2.this);
        dialog1.setIcon(R.drawable.alert);
        dialog1.setTitle("알림");
        dialog1.setMessage("이번주 레포트는 Dialog 입니다");
        dialog1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Report2.this, "확인했습니다", Toast.LENGTH_SHORT).show();
            }
        });
        dialog1.setCancelable(false);
        dialog1.show();
    }

    public void showDialog2(View view) {
        EditText input = new EditText(this);

        AlertDialog.Builder dialog2 = new AlertDialog.Builder(Report2.this);
        dialog2.setTitle("이름 입력");
        dialog2.setView(input);
        dialog2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String check = input.getText().toString();

                if (check.isEmpty()) {
                    Toast.makeText(getBaseContext(), "입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), check, Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog2.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        dialog2.setCancelable(false);
        dialog2.show();
    }

    public void showDialog3(View view) {
        final boolean[] select = {false, false, false, false, false};

        AlertDialog.Builder dialog3 = new AlertDialog.Builder(Report2.this);
        dialog3.setIcon(android.R.drawable.btn_star_big_on);
        dialog3.setTitle("당신의 취미는?");
        dialog3.setMultiChoiceItems(R.array.hobby, select, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                select[i] = isChecked;
            }
        });
        dialog3.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                StringBuilder result = new StringBuilder();
                String[] select_hobby = getResources().getStringArray(R.array.hobby);
                boolean anySelected = false;

                for (int j = 0; j < select.length; j++) {
                    if (select[j]) {
                        result.append(select_hobby[j]).append(", ");
                        anySelected = true;
                    }
                }

                if (anySelected) {
                    result.setLength(result.length() - 2);
                }

                if (anySelected) {
                    Toast.makeText(getBaseContext(), "취미 : " + result.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "취미를 선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog dialog = dialog3.create();
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.show();
    }
}