package com.example.week7;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
        dialog.setIcon(android.R.drawable.ic_popup_sync);
        dialog.setTitle("프로그래스 다이얼로그\n(Horizontal)");
        dialog.setMessage("로딩이 완료되었습니다");
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context,"취소하였습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i <= 10; i++) {
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
        Toast.makeText(context, "로딩이 완료되었습니다", Toast.LENGTH_SHORT).show();
    }
}
