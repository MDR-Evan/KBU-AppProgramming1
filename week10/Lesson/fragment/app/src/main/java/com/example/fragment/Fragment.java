package com.example.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragment extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout layout1, layout2, layout3;
    private FragmentManager manager;
    private int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);

        manager = getSupportFragmentManager();
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
            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.INVISIBLE);
            layout3.setVisibility(View.INVISIBLE);
            flag = 1;
        } else if (check == R.id.item2) {
            layout1.setVisibility(View.INVISIBLE);
            layout2.setVisibility(View.VISIBLE);
            layout3.setVisibility(View.INVISIBLE);
            flag = 2;
        } else {
            layout1.setVisibility(View.INVISIBLE);
            layout2.setVisibility(View.INVISIBLE);
            layout3.setVisibility(View.VISIBLE);
            flag = 3;
        }
        item.setChecked(true);
        onResume();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

//      Layout 1
        Button buttonA = findViewById(R.id.buttonA);
        buttonA.setOnClickListener(this);
        Button buttonB = findViewById(R.id.buttonB);
        buttonB.setOnClickListener(this);
//      Layout 2
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
//      Layout 3
        Button buttona = findViewById(R.id.buttona);
        buttona.setOnClickListener(this);
        Button buttonb = findViewById(R.id.buttonb);
        buttonb.setOnClickListener(this);

        button1.performClick();
        buttona.performClick();
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        FragmentTransaction transaction = manager.beginTransaction();

        int check = view.getId();

        if (check == R.id.buttonA || check == R.id.button1 || check == R.id.buttona) {
            fragment = new FragmentA(flag);
        } else {
            fragment = new FragmentB(flag);
        }

        if (check == R.id.buttonA || check == R.id.buttonB) {
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
        } else if (check == R.id.button1 || check == R.id.button2) {
            transaction.add(R.id.frameLayout, fragment);
        } else {
            transaction.add(R.id.frameContainer, fragment);
        }
        transaction.commit();
    }
}