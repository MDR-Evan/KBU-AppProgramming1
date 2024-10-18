package com.example.dialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ex_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);
    }

    public void showDialog1(View view) {
        ProgressDialog dialog = ProgressDialog.show(Ex_3.this, "Please wait for 5 seconds...", "you can use this to perform extreme calculations...", true);
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5);
                } catch (InterruptedException e) {
                    Toast.makeText(getBaseContext(), "", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        }.start();
    }

    public void showDialog2(View view) {
        DownloadTask task = new DownloadTask(Ex_3.this);
        task.execute();
    }

    public void showDialog3(View view) {
        SpannableString site = new SpannableString("https://www.m.naver.com");
        Linkify.addLinks(site, Linkify.ALL);
        AlertDialog.Builder builder = new AlertDialog.Builder(Ex_3.this);
        builder.setTitle("Naver");
        builder.setMessage(site);
        builder.setPositiveButton("OK", null);
        builder.create();
        builder.show();
    }
}