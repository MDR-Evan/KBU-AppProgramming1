package com.example.urlconnection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageRunnable implements Runnable {
    private Context context;
    private String page;
    private Bitmap bitmap;
    private Handler handler;

    public ImageRunnable(Context context, String page) {
        this.context = context;
        this.page = page;
        bitmap = null;
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
            bitmap = BitmapFactory.decodeStream(stream);
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
    }

    protected Bitmap getPage() {
        return bitmap;
    }
}
