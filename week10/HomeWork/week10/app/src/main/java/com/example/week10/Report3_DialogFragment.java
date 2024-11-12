package com.example.week10;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Report3_DialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        builder.setTitle("DialogFragment");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setMessage("DialogFragment 내용이 잘 보이지요");
        builder.setPositiveButton("OK", (dialog, which) -> dismiss());

        return builder.create();
    }
}
