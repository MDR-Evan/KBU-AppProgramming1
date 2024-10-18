package com.example.dialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Ex_2 extends AppCompatActivity {
    ProgressDialog progress, progress1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);


    }

    public void showDialog1(View view) {
        AlertDialog.Builder dialog1 = new AlertDialog.Builder(Ex_2.this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
        dialog1.setMessage("앱을 종료하시겠습니까?");
        dialog1.setTitle("Emergency");
        dialog1.setIcon(R.drawable.ic_launcher_foreground);
        dialog1.setPositiveButton("확인이에요우~", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(),"확인이네요우~",Toast.LENGTH_SHORT).show();
            }
        });
        dialog1.setNeutralButton("취소에요우~", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(),"취소네요우~",Toast.LENGTH_SHORT).show();
            }
        });
        dialog1.setCancelable(false);
        dialog1.show();
    }

    public void showDialog2(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String temp = year + "년";
                temp += (i1 + 1) + "월";
                temp += i2 + "일";

                Toast.makeText(getBaseContext(), temp, Toast.LENGTH_SHORT).show();
            }
        };
        DatePickerDialog dialog2 = new DatePickerDialog(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert, dateSetListener, year, month, day);
        dialog2.show();
    }

    public void showDialog3(View view) {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Toast.makeText(getBaseContext(), i + ":" + i1, Toast.LENGTH_SHORT).show();
            }
        };
        TimePickerDialog dialog = new TimePickerDialog(Ex_2.this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert, timeSetListener, 0, 0, false);
        dialog.show();
    }

    public void showDialog4(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        Dialog dialog = new Dialog(Ex_2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_birthday);

        Button button1 = dialog.findViewById(R.id.button1);
        Button button2 = dialog.findViewById(R.id.button2);
        NumberPicker picker = dialog.findViewById(R.id.picker);

        picker.setMinValue(year - 80);
        picker.setMaxValue(year + 15);
        picker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        picker.setWrapSelectorWheel(false);
        picker.setValue(year - 20);

        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Ex_2.this, String.valueOf(picker.getValue()),
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void showDialog5(View view) {
        String options = "0321458769ACBFED";
        CharacterPickerDialog dialog = new CharacterPickerDialog(Ex_2.this, new View(this), null, options, false) {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Selected Character : " + ((Button) v).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        };
        dialog.show();
    }

    public void showDialog6(View view) {
        progress = new ProgressDialog(Ex_2.this, AlertDialog.THEME_HOLO_DARK);
        progress.setTitle("공지");
        progress.setMessage("잠시만 기다려주세요.\n프로그램 로딩중입니다.\n중지하시겠습니까?");
        progress.setButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                progress.dismiss();
                Toast.makeText(getBaseContext(), "중지되었습니다", Toast.LENGTH_SHORT).show();
            }
        });
        progress.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        progress.show();
    }

    public void showDialog7(View view) {
        progress1 = new ProgressDialog(Ex_2.this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
        progress1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress1.setMessage("로딩...");
        progress1.setMax(200);
        progress1.show();
        for (int i = 1; i <= 10; i++) {
            progress1.setProgress(i * 10);
        }
    }
}