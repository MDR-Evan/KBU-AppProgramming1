package com.example.week7;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
        ProgressDialog dialog1 = new ProgressDialog(Report3.this);
        dialog1.setIcon(android.R.drawable.ic_popup_sync);
        dialog1.setTitle("프로그래스 다이얼로그\n(Spinner)");
        dialog1.setMessage("현재 진행중입니다.");
        dialog1.setIndeterminate(true);
        dialog1.setButton(DialogInterface.BUTTON_POSITIVE, "취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(),"취소하였습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        dialog1.show();
    }

    public void showDialog2(View view) {
        DownloadTask task = new DownloadTask(Report3.this);
        task.execute();
    }

    public void showDialog3(View view) {
        CustomDialog dialog = new CustomDialog(this);
        dialog.setCancelable(false);
        dialog.show();
    }
}