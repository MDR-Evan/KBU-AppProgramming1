package com.example.widget;

import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DisplayThread extends Thread{
    ProgressBar progressBar;
    TextView textView;
    int progress = 0;

    public DisplayThread(ProgressBar progressBar, TextView textView) {
        this.progressBar = progressBar;
        this.textView = textView;
    }

    @Override
    public void run() {
        while (progress < 100) {
            progress++;
            textView.post(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(progress);
                    textView.setText(progress + "%");
                }
            });
            SystemClock.sleep(100);
        }
    }
}
