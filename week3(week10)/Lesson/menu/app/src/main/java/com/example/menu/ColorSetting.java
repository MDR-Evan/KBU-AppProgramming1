package com.example.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;

public class ColorSetting {
    private Context context;
    private ActionBar actionBar;
    TextView red_Text, green_Text, blue_Text;
    SeekBar red_Seek, green_Seek, blue_seek;
    Button button;

    public ColorSetting(ActionBar actionBar, Context context) {
        this.actionBar = actionBar;
        this.context = context;
    }

    public void setColor() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_dialog, null);
        red_Text = view.findViewById(R.id.redText);
        green_Text = view.findViewById(R.id.greenText);
        blue_Text = view.findViewById(R.id.blueText);
        button = view.findViewById(R.id.button);
        button.setBackgroundColor(MainActivity.current);

        red_Seek = view.findViewById(R.id.redSeek);
        red_Seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        green_Seek = view.findViewById(R.id.greenSeek);
        green_Seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blue_seek = view.findViewById(R.id.blueSeek);
        blue_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Select Actionbar Background Color");
        builder.setView(view);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                actionBar.setBackgroundDrawable(new ColorDrawable(MainActivity.current));
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "canceled", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void changeColor() {
        int red = red_Seek.getProgress();
        int green = green_Seek.getProgress();
        int blue = blue_seek.getProgress();

        MainActivity.current = Color.rgb(red, green, blue);

        red_Text.setText("Red : " + red + "(" + (red == 0 ? "00" : String.format("%2H", red)) + ")");
        green_Text.setText("Green : " + green + "(" + (green == 0 ? "00" : String.format("%2H", green)) + ")");
        blue_Text.setText("Blue : " + blue + "(" + (blue == 0 ? "00" : String.format("%2H", blue)) + ")");

        button.setBackgroundColor(MainActivity.current);
    }
}
