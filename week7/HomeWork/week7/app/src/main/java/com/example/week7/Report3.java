package com.example.week7;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Report3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report3);
    }

    public void showDialog1(View view) {
        ProgressBar progress_spinner = new ProgressBar(this);
        TextView textView = new TextView(this);

        AlertDialog.Builder dialog1 = new AlertDialog.Builder(Report3.this);
        dialog1.setIcon(android.R.drawable.ic_popup_sync);
        dialog1.setTitle("프로그래스 다이얼로그(Spinner)");
        dialog1.setMessage("잠시만 기다려 주세요.");
        dialog1.setView(progress_spinner);
        dialog1.setView(textView);

        dialog1.show();
    }
}