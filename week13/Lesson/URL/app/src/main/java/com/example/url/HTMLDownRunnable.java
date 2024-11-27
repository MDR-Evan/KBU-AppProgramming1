package com.example.url;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.LogRecord;

public class HTMLDownRunnable implements Runnable{
    private Context context;
    private String page;
    private Handler handler = new Handler();
    private StringBuilder builder = new StringBuilder();

    public HTMLDownRunnable(Context context, String page) {
        this.context = context;
        this.page = page;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(page);
            InputStream stream = url.openStream();
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            reader.close();
            streamReader.close();
            stream.close();
        } catch (IOException e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            throw new RuntimeException(e);
        }
    }

    public String getResult() {
        return builder.toString();
    }
}
