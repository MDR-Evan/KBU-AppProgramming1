package com.example.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class DownloadTask extends AsyncTask<Void, Void, Void> {
    private Context context;
    private ProgressDialog dialog;

    public DownloadTask(Context context) {
        this.context = context;
        this.dialog = new ProgressDialog(context, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
    }

    @Override
    protected void onPreExecute() {
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMessage("다운로드 중 입니다...");
        dialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i < 10; i++) {
            dialog.setProgress(i * 10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        dialog.dismiss();
    }
}
