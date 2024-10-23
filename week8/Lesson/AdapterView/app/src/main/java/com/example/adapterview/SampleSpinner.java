package com.example.adapterview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SampleSpinner extends AppCompatActivity {
    Spinner spinner, spinner1, spinner2;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_spinner);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        display(flag, android.R.layout.simple_spinner_item);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int check = item.getItemId();
        int id = 0;

        if (check == R.id.menu1) {
            flag = false;
            id = android.R.layout.simple_spinner_item;
        } else if (check == R.id.menu2) {
            flag = false;
            id = android.R.layout.simple_spinner_dropdown_item;
        } else if (check == R.id.menu3) {
            flag = true;
            id = android.R.layout.simple_spinner_item;
        } else {
            flag = true;
            id = android.R.layout.simple_spinner_dropdown_item;
        }
        item.setChecked(true);
        display(flag, id);
        return true;
    }

    private void display(boolean flag, int id) {
        if (flag) {
            spinner = spinner1;
            spinner1.setVisibility(View.VISIBLE);
            spinner2.setVisibility(View.INVISIBLE);
        } else {
            spinner = spinner2;
            spinner1.setVisibility(View.INVISIBLE);
            spinner2.setVisibility(View.VISIBLE);
        }

        spinner.setPrompt("과일을 고르세요");
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fruits1, id);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean first = false;

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (first) {
                    Toast.makeText(SampleSpinner.this,adapter.getItem(i), Toast.LENGTH_SHORT).show();
                } else {
                    first = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}