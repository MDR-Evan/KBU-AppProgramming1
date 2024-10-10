package com.example.widget;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    ProgressBar progressBar1, progressBar2;
    int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ProgressBar progressBar1 = findViewById(R.id.progress1);
        ProgressBar progressBar2 = findViewById(R.id.progress2);
        ToggleButton button = findViewById(R.id.button1);
        TextView textView1 = findViewById(R.id.textView1);

        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    progressBar1.setVisibility(View.VISIBLE);
                    progressBar2.setVisibility(View.INVISIBLE);
                    if (type == 1) {
                        DisplayTask task = new DisplayTask(progressBar1, textView1);
                        task.execute();
                    } else {
                        DisplayThread thread = new DisplayThread(progressBar1, textView1);
                        thread.start();
                    }
                } else {
                    progressBar1.setVisibility(View.INVISIBLE);
                    progressBar2.setVisibility(View.VISIBLE);
                    if (type == 1) {
                        DisplayTask task = new DisplayTask(progressBar2, textView1);
                        task.execute();
                    } else {
                        DisplayThread thread = new DisplayThread(progressBar2, textView1);
                        thread.start();
                    }
                }
            }
        });

        ProgressBar progressBar3 = findViewById(R.id.progress3);
        TextView textView2 = findViewById(R.id.textView2);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type == 1) {
                    DisplayTask task = new DisplayTask(progressBar3, textView2);
                    task.execute();
                } else {
                    DisplayThread thread = new DisplayThread(progressBar3, textView2);
                    thread.start();
                }
            }
        });
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
        if (check == R.id.item1) {
            type = 1;
        } else if (check == R.id.item2){
            type = 2;
        }
        item.setChecked(true);

        return true;
    }
}