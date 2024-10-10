package com.example.widget;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DisplayTask extends AsyncTask<Void, Integer, Void> {
    private ProgressBar progressBar;
    private TextView textView;
    private int progress;

    public DisplayTask(ProgressBar progressBar, TextView textView) {
        this.progressBar = progressBar;
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        progress = 0;
        textView.setText(progress + "%");
    }

    @Override
    protected Void doInBackground(Void... voids) {
        while (progress < 100) {
            progress++;
            publishProgress(progress);
            SystemClock.sleep(100);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        textView.setText(values[0] + "%");
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Void unused) {
        if (progressBar.getId() == R.id.progress1) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }


}
