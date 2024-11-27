package com.example.url;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HTMLDownTask extends AsyncTask<String, String, String> {
    private Context context;

    public HTMLDownTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(strings[0]);
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
            publishProgress(e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        Toast.makeText(context, values[0], Toast.LENGTH_SHORT).show();
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
