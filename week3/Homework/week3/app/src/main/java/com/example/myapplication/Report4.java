package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class Report4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report4);

        RadioButton shortshow = findViewById(R.id.shortshow);
        RadioButton longshow = findViewById(R.id.longshow);
        EditText editText = findViewById(R.id.editText);
        Button toastbutton = findViewById(R.id.toastButton);
        Button snackbarbutton = findViewById(R.id.snackbarButton);
        Button confirmbutton = findViewById(R.id.confirmButton);

            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = editText.getText().toString();
                    if (text.equals("")) {
                        Toast.makeText(getBaseContext(), "입력해주세요", Toast.LENGTH_SHORT).show();
                    } else {
                        int T_check;
                        int S_check;
                        if (shortshow.isChecked()) {
                            T_check = Toast.LENGTH_SHORT;
                            S_check = Snackbar.LENGTH_SHORT;
                        } else {
                            T_check = Toast.LENGTH_LONG;
                            S_check = Snackbar.LENGTH_LONG;
                        }

                        int button_check = view.getId();
                        if (button_check == R.id.toastButton) {
                            Toast.makeText(getBaseContext(), String.format("%s", text), T_check).show();
                        } else if (button_check == R.id.snackbarButton) {
                            Snackbar.make(view, String.format("%s", text), S_check).show();
                        } else {
                            Snackbar.make(view, String.format("확인하시겠습니까?", text), Snackbar.LENGTH_INDEFINITE).setAction("확인", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar.make(view, String.format("%s", text), S_check).show();
                                }
                            }).show();
                        }
                    }
                }
            };
        toastbutton.setOnClickListener(onClickListener);
        snackbarbutton.setOnClickListener(onClickListener);
        confirmbutton.setOnClickListener(onClickListener);
    }
}