package com.example.week7;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class CustomDialog extends Dialog {
    private Context context;

    public CustomDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams window = new WindowManager.LayoutParams();
        window.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.dimAmount = 0.5f;
        getWindow().setAttributes(window);
        setContentView(R.layout.customdialog);
        EditText editText_id = findViewById(R.id.editText_id);
        EditText editText_pw = findViewById(R.id.editText_pw);
        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editText_id.getText().toString();
                String pw = editText_pw.getText().toString();

                if (id.isEmpty() || pw.isEmpty()) {
                    Toast.makeText(context, "정확하게 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, String.format("%s / %s", id, pw), Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button okButton = findViewById(R.id.btnOk);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editText_id.getText().toString();
                String pw = editText_pw.getText().toString();

                if (id.isEmpty() || pw.isEmpty()) {
                    Toast.makeText(context, "정확하게 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, String.format("%s / %s", id, pw), Toast.LENGTH_SHORT).show();
                }

                dismiss();
            }
        });
        Button cancelButton = findViewById(R.id.btnCancle);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"취소하였습니다.",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }
}
