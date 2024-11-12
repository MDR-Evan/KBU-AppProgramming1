package com.example.week10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class Report3 extends AppCompatActivity implements Report3_ListFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report3);

        Button listFragmentButton = findViewById(R.id.list_fragment_button);
        Button dialogFragmentButton = findViewById(R.id.dialog_fragment_button);
        Button fragmentButton = findViewById(R.id.fragment_button);

        listFragmentButton.setOnClickListener(v -> replaceFragment(new Report3_ListFragment()));

        dialogFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Report3_DialogFragment dialogFragment = new Report3_DialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "dialog");
            }
        });

        fragmentButton.setOnClickListener(v -> replaceFragment(new Report3_Fragment()));

    }
    @Override
    public void onItemSelected(String item) {
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
