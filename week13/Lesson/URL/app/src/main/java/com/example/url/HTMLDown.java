package com.example.url;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTMLDown {
    private Context context;

    public HTMLDown(Context context) {
        this.context = context;
    }

    public String download(String page) {
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(page);

            InputStream stream = url.openStream();
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                builder.append(line).append("\n");
            }
            scanner.close();
            reader.close();
            streamReader.close();
            stream.close();

        } catch (MalformedURLException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return builder.toString();
    }
}
