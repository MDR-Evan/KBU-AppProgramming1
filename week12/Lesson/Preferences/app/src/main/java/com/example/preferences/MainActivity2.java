package com.example.preferences;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private LinearLayout layout;
    private CheckBox check_Auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main);
        EditText edit_id = findViewById(R.id.edit_id);
        EditText edit_pw = findViewById(R.id.edit_pw);
        check_Auto = findViewById(R.id.checkbox_AutoLogin);
        Button button_login = findViewById(R.id.button_login);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String id = preferences.getString("id", ""),
               pw = preferences.getString("pw", "");
        boolean check = preferences.getBoolean("auto", false);
        String color = preferences.getString("color", "");

        if (check) {
            edit_id.setText(id);
            edit_pw.setText(pw);
        }  else {
            edit_id.setText("");
            edit_pw.setText("");
        }
        check_Auto.setChecked(check);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputid = edit_id.getText().toString();
                String inputpw = edit_pw.getText().toString();
                if (inputid.isEmpty() || inputpw.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    if (inputid.equals(preferences.getString("id", "")) && inputpw.equals(preferences.getString("pw", ""))) {
                        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                        intent.putExtra("id", inputid);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity2.this, "ID와 PW를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        check_Auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("id", preferences.getString("id", ""));
                editor.putString("pw", preferences.getString("pw", ""));
                editor.putBoolean("auto", b);
                editor.apply();
                if (!b) {
                    edit_id.setText("");
                    edit_pw.setText("");
                } else {
                    edit_id.setText(preferences.getString("id", ""));
                    edit_pw.setText(preferences.getString("pw", ""));
                }
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
        Intent intent = null;
        int check = item.getItemId();
        if (check == R.id.item1) {
            intent = new Intent(Settings.ACTION_SETTINGS);
            check_Auto.setChecked(false);
        } else {
            intent = new Intent(getBaseContext(), CustomSetting.class);
        }
        startActivity(intent);
        item.setChecked(true);

        return true;
    }
}