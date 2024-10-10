package com.example.sample1;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    boolean flag = true;
    boolean flagImage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    textView.setTextColor(getColor(R.color.blue));
                    flag = false;
                } else {
                    textView.setTextColor(getColor(R.color.red));
                    flag = true;
                }
                Toast.makeText(getBaseContext(),"텍스트의 색상이 변경되었습니다.", Toast.LENGTH_SHORT).show();
                Snackbar.make(view, "텍스트의 색상이 변경되었나요?", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });

        ImageView imageView = findViewById(R.id.imageView);
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", 360);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagImage) {
                    animator.start();
                    flagImage = false;
                } else {
                    animator.cancel();
                    flagImage = true;
                }
            }
        });
    }
}