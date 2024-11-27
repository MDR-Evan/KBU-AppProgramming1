package com.example.url;

import android.content.Context;
import android.os.Handler;
import android.renderscript.ScriptGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HTMLThread extends Thread{
    private Context context;
    private Handler handler = new Handler();
    private String page;
    private StringBuilder builder = new StringBuilder();

    public HTMLThread(Context context, String page) {
        this.context = context;
        this.page = page;
    }

    public HTMLThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        URL url = null;
        try {
            url = new URL(page);
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
        } catch (MalformedURLException e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        super.run();
    }

    public String getResult() {
        return builder.toString();
    }
}
