    package com.example.urlconnection;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.ExecutionException;

    public class MainActivity extends AppCompatActivity {
    final String page = "https://www.kbu.ac.kr";
    private TextView textView;
    private WebView webView;
    private int type = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(null);
                webView.loadUrl(page);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(null);
                webView.clearView();

                if (type == 1) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    HTMLDown down = new HTMLDown(MainActivity.this);
                    textView.setText(down.download(page));
                } else if (type == 2) {
                    HTMLAsync async = new HTMLAsync(MainActivity.this);
                    try {
                        String message = async.execute(page).get();
                    } catch (ExecutionException | InterruptedException e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else if (type == 3) {
                    HTMLThread thread = new HTMLThread(MainActivity.this, page);
                    thread.start();
                    try {
                        thread.join();
                        textView.setText(thread.getResult());
                    } catch (InterruptedException e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    HTMLRunnable runnable = new HTMLRunnable(MainActivity.this, page);
                    Thread thread = new Thread(runnable);
                    thread.start();
                    try {
                        thread.join();
                        textView.setText(runnable.getPage());
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
        webView.clearView();
        textView.setText(null);
        return true;
    }
}