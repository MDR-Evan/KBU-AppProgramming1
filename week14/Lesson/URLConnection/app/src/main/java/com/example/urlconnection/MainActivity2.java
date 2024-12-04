package com.example.urlconnection;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.ExecutionException;

public class MainActivity2 extends AppCompatActivity {
    private final String page = "https://manage.kbu.ac.kr/resources/_Plugin/namoeditor/binary/images/000091/20240927155049274_K3FN4B29.png";
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
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    ImageDown down = new ImageDown(MainActivity2.this);
                    imageView.setImageBitmap(down.downImage(page));
                } else if (type == 2) {
                    ImageAsync async = new ImageAsync(MainActivity2.this);
                    try {
                        imageView.setImageBitmap(async.execute(page).get());
                    } catch (ExecutionException | InterruptedException e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else if (type == 3) {
                    ImageThread thread = new ImageThread(MainActivity2.this, page);
                    thread.start();
                    try {
                        thread.join();
                        imageView.setImageBitmap(thread.getResult());
                    } catch (InterruptedException e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    ImageRunnable runnable = new ImageRunnable(MainActivity2.this, page);
                    Thread thread = new Thread(runnable);
                    thread.start();
                    try {
                        thread.join();
                        imageView.setImageBitmap(runnable.getPage());
                    } catch (InterruptedException e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
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
        item.setChecked(true);
        imageView.setImageBitmap(null);
        return true;
    }
}