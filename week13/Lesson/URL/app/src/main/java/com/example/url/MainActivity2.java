package com.example.url;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    final String site = "https://manage.kbu.ac.kr/resources/_Plugin/namoeditor/binary/images/000091/20240927155049274_K3FN4B29.png";
    private ImageView imageView;
    private int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.imageView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageBitmap(null);
                if (type == 1) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy
                                                                    .Builder()
                                                                    .permitAll()
                                                                    .build();
                    StrictMode.setThreadPolicy(policy);
                    ImageDown imageDown = new ImageDown(getBaseContext());
                    imageView.setImageBitmap(imageDown.download(site));
                } else if (type == 2) {

                }  else if (type == 3) {

                } else {

                }
            }
        });
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
            type = 1;
        } else if (check == R.id.item2) {
            type = 2;
        } else if (check == R.id.item3) {
            type = 3;
        } else {
            type = 4;
        }

        imageView.setImageBitmap(null);
        item.setChecked(true);
        return true;
    }
}