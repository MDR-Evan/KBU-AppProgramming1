package com.example.preferences;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    final String PREFER_name = "UserID";
    private SharedPreferences preferences;
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
        preferences = getSharedPreferences(PREFER_name, MODE_PRIVATE);
        String id = preferences.getString("id", "");
        String pw = preferences.getString("pw", "");
        boolean check = preferences.getBoolean("auto", false);
        String color = preferences.getString("color", "");

        if (id.equals("")) {
            preferencesDialog();
        } else {
            edit_id.setText(id);
            edit_pw.setText(pw);
            check_Auto.setChecked(check);
            layout.setBackgroundColor(Color.parseColor(color));
        }
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputid = edit_id.getText().toString();
                String inputpw = edit_pw.getText().toString();
                if (inputid.isEmpty() || inputpw.isEmpty()) {
                    Toast.makeText(MainActivity.this, "입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    if (inputid.equals(preferences.getString("id", "")) && inputpw.equals(preferences.getString("pw", ""))) {
                        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                        intent.putExtra("id", inputid);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "ID와 PW를 확인해주세요.", Toast.LENGTH_SHORT).show();
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

    private void preferencesDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("데이터 입력");

        View dialog = View.inflate(this, R.layout.dialog, null);
        builder.setView(dialog);
        EditText D_edit_id = dialog.findViewById(R.id.D_edit_id);
        EditText D_edit_pw = dialog.findViewById(R.id.D_edit_pw);
        CheckBox D_check_auto = dialog.findViewById(R.id.D_checkbox_AutoLogin);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String inputid = D_edit_id.getText().toString();
                String inputpw = D_edit_pw.getText().toString();
                if (inputid.isEmpty() || inputpw.isEmpty()) {
                    Toast.makeText(MainActivity.this, "입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = preferences.edit();
                    if (check_Auto.isChecked()) {
                        editor.putString("id", inputid);
                        editor.putString("pw", inputpw);
                        editor.putBoolean("auto", check_Auto.isChecked());
                        editor.putString("color", "");
                        Toast.makeText(MainActivity.this, "Preference에 정보가 저장되었습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        editor.remove("id").remove("pw").remove("color").remove("auto");
                        editor.apply();
                    }
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                View cancel = View.inflate(getBaseContext(), R.layout.dialog_cancle, null);
                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int x = (int) (Math.random() * display.getWidth());
                int y = (int) (Math.random() * display.getHeight());
                Toast toast = new Toast(getBaseContext());
                toast.setGravity(Gravity.TOP | Gravity.LEFT, x, y);
                toast.setView(cancel);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        builder.create();
        builder.show();
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
            preferencesDialog();
            check_Auto.setChecked(false);
        } else {
            colorDialog();
        }
        item.setChecked(true);

        return true;
    }

    private void colorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("배경색 선택");
        builder.setSingleChoiceItems(R.array.background_color, 3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String[] value = getResources().getStringArray(R.array.color_values);
                layout.setBackgroundColor(Color.parseColor(value[i]));
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("color", value[i]);
                editor.apply();
            }
        });
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "배경색이 저장되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
}