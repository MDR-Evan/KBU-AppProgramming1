package com.example.urlconnection;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTMLThread extends Thread {
    private Context context;
    private String page;
    private StringBuilder builder;
    private Handler handler;

    public HTMLThread(Context context, String page) {
        this.context = context;
        this.page = page;
        builder = new StringBuilder();
        handler = new Handler();
    }

    @Override
    public void run() {
        try {
            URL url = new URL(page);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            InputStream stream = connection.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while((line = reader.readLine()) != null) {
                builder.append(line + "\n");
            }
            reader.close();
            streamReader.close();
            stream.close();
            connection.disconnect();
        } catch (IOException e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        super.run();
    }

    public String getResult() {
        return builder.toString();
    }
}
