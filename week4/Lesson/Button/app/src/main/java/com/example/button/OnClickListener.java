// OnClickListener 클래스 별도 생성

package com.example.button;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

public class OnClickListener implements View.OnClickListener {
    TextView textView;

    protected OnClickListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onClick(View view) {
        int check = view.getId();
        if (check == R.id.r_button) {
            textView.setBackgroundColor(Color.rgb(255,0,0));
        } else if (check == R.id.g_button) {
            textView.setBackgroundColor(Color.rgb(0,255,0));
        } else if (check == R.id.b_button) {
            textView.setBackgroundColor(Color.rgb(0,0,255));
        }
    }
}
