
package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Report1 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);

        Button naver = findViewById(R.id.naver);
        Button dial = findViewById(R.id.dial);
        Button gallery = findViewById(R.id.gallery);
        Button exit = findViewById(R.id.exit);

        naver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });

        Report1_OnClickListener onClickListener = new Report1_OnClickListener(dial, gallery);
        dial.setOnClickListener(onClickListener);

        View.OnClickListener onClickListener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                view.getContext().startActivity(intent);
            }
        };
        gallery.setOnClickListener(onClickListener1);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(getBaseContext(),"끝냅니다",Toast.LENGTH_SHORT).show();
            }
        });
    }


/**[ On Click 속성 ] * 응급전화 걸기 < 교수님께 질문 필수 권한부여를 꼭 해야 하는가 ************************/
    private static final int REQUEST_CALL_PERMISSION = 1;

    public void buttonClicked(View view) {
        if (ContextCompat.checkSelfPermission(Report1.this,
                android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Report1.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:119"));
            startActivity(intent);
        }
    }
/**************************************************************************************************/
}