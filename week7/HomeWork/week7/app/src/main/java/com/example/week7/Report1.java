package com.example.week7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Report1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int check = item.getItemId();
        if (item.getItemId() == check) {
            showDialog();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Report1.this);
        builder.setCancelable(false);
        builder.setTitle("알림");
        builder.setMessage("종료를 원합니까 ?");
        builder.setIcon(R.drawable.alert);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(),"Back Button을 눌렀다.",Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}