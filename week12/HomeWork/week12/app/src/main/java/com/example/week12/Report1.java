package com.example.week12;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Report1 extends AppCompatActivity {
    final String PREFER_NAME = "USERID";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.report1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int test = item.getItemId();
        if (test == R.id.Report1_item1) {
            GameSettingDialog();
        }
        item.setChecked(true);
        return true;
    }

    private void GameSettingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Report1.this);
        View dialog = View.inflate(this, R.layout.activity_report1_gamesetting, null);
        TextView soundText = dialog.findViewById(R.id.Report1_soundText),
                 brightnessText = dialog.findViewById(R.id.Report1_brightnessText),
                 difficultyText = dialog.findViewById(R.id.Report1_difficultyText);
        SeekBar soundSeek = dialog.findViewById(R.id.Report1_soundSeek),
                brightnessSeek = dialog.findViewById(R.id.Report1_brightnessSeek);
        RadioButton level_e = dialog.findViewById(R.id.Report1_difficultyRadio1),
                    level_m = dialog.findViewById(R.id.Report1_difficultyRadio2),
                    level_h = dialog.findViewById(R.id.Report1_difficultyRadio3);
        RadioGroup difficultyGroup = dialog.findViewById(R.id.Report1_difficultyGroup);

        sound(soundText, soundSeek);
        brightness(brightnessText, brightnessSeek);
        difficulty(difficultyGroup, difficultyText, level_e, level_m, level_h);

        builder.setIcon(R.drawable.kyungbok);
        builder.setTitle("환경 설정");
        builder.setView(dialog);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                preferences = getSharedPreferences(PREFER_NAME, MODE_PRIVATE);
                String Sound = soundText.getText().toString(),
                       Brightness = brightnessText.getText().toString(),
                       Difficulty = difficultyText.getText().toString();

                if (Sound.isEmpty() || Brightness.isEmpty() || Difficulty.isEmpty()) {
                    Toast.makeText(Report1.this, "입력해 주세요", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("sound", Sound)
                          .putString("brightness", Brightness)
                          .putString("difficulty", Difficulty)
                          .apply();
                    Toast.makeText(Report1.this, "입력되었습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Report1.this, "종료되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create();
        builder.show();
    }

    private void sound(TextView soundText, SeekBar soundSeek) {
        soundSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                soundText.setText(String.format("%d", i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void brightness(TextView brightnessText, SeekBar brightnessSeek) {
        brightnessSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                brightnessText.setText(String.format("%d", i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void difficulty(RadioGroup difficultyGroup, TextView difficultyText, RadioButton level_e, RadioButton level_m, RadioButton level_h) {
        difficultyGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.Report1_difficultyRadio1) {
                difficultyText.setText("Easy");
            } else if (checkedId == R.id.Report1_difficultyRadio2) {
                difficultyText.setText("Medium");
            } else if (checkedId == R.id.Report1_difficultyRadio3) {
                difficultyText.setText("Hard");
            }
        });
    }
}