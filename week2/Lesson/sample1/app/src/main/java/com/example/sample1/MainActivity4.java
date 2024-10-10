package com.example.sample1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = editText.getText().toString();

                if (value.isEmpty()) {
                    Toast.makeText(getBaseContext(), "원의 반지름 값을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    float radius = Float.parseFloat(value);
                    float area = (float) (Math.PI * radius * radius);

                    textView.setText(String.format("원의 면적 : %.2f\n", area));
                }
            }
        });
    }
}