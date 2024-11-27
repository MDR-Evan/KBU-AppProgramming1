package com.example.url;

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
    final String site = "http://192.168.93.1:215";
//    final String site = "https://kbu.ac.kr/";
    private TextView textView;
    private WebView webView;
    private int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        textView = findViewById(R.id.textView);
        webView.getSettings().setJavaScriptEnabled(true);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(null);
                webView.loadUrl(site);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.clearView();
                textView.setText("");
                if (type == 1) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy
                                                                    .Builder()
                                                                    .permitAll()
                                                                    .build();

                    StrictMode.setThreadPolicy(policy);
                    HTMLDown html = new HTMLDown(getBaseContext());
                    textView.setText(html.download(site));

                } else if (type == 2) {
                    HTMLDownTask html = new HTMLDownTask(getBaseContext());
                    try {
                        String temp = html.execute(site).get();
                        textView.setText(temp);
                    } catch (ExecutionException | InterruptedException e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }

                } else if (type == 3) {
                    HTMLThread html = new HTMLThread(getBaseContext(), site);
                    html.start();
                    try {
                        html.join();
                        textView.setText(html.getResult());
                    } catch (InterruptedException e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                } else {
                    HTMLDownRunnable html = new HTMLDownRunnable(getBaseContext(), site);
                    Thread thread = new Thread(html);
                    thread.start();
                    try {
                        thread.join();
                        String temp = html.getResult();
                        textView.setText(temp);
                    } catch (InterruptedException e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
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

        webView.clearView();
        textView.setText(null);
        item.setChecked(true);
        return true;
    }
}