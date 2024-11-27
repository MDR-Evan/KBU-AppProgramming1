package com.example.url;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageDown {
    private Context context;
    private ProgressDialog dialog;

    public ImageDown(Context context) {
        this.context = context;
/*        dialog = new ProgressDialog(context);
        dialog.setTitle("DownLoad Image");
        dialog.setMessage("Loading.....");
        dialog.setIndeterminate(false);
        dialog.show();*/
    }

    public Bitmap download(String page) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(page);
            InputStream stream = url.openStream();
            bitmap = BitmapFactory.decodeStream(stream);

            stream.close();
        } catch (IOException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

//        dialog.dismiss();
        return bitmap;
    }
}
