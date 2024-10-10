package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

public class Report1_OnClickListener implements View.OnClickListener {
    Button dial;
    Button gallery;

    public Report1_OnClickListener(Button dial, Button gallery) {
        this.dial = dial;
        this.gallery = gallery;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:119"));
        view.getContext().startActivity(intent);
    }
}
