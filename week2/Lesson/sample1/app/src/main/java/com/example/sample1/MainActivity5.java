package com.example.sample1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String value = editText.getText().toString();
                if (value.equals("")) {
                    Snackbar.make(view, "입력해주세요.", BaseTransientBottomBar.LENGTH_SHORT).show();
                } else {
                    int test = Integer.parseInt(value);
                    textView.setText(String.format("%d는 %s입니다.",test, test % 2 == 0 ? "짝수" : "홀수"));
                }
                return false;
            }
        });
    }
}