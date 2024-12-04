package com.example.urlconnection;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HTMLDown {
    private Context context;

    public HTMLDown(Context context) {
        this.context = context;
    }

    public String download(String page) {
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(page);
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(5000);
            InputStream stream = connection.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            builder.append("contentType= ")
                   .append(connection.getContentType())
                   .append("\n");
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
            }
            reader.close();
            streamReader.close();
            stream.close();
        } catch (IOException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return builder.toString();
    }
}
