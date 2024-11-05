package com.example.menu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    static int current = 0xffff0000;
    TextView textView;
    boolean codeflag = true, flag = true;
    int type = 0;
    PopupMenu popupMenu;
    EditText editText;
    ActionBar actionBar;
    ImageView imageView;
    ActionMode actionMode = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setTitle("ActionBar를 Switch로 (On/Off) 하기");
        actionBar.setBackgroundDrawable(new ColorDrawable(current));
        Switch toggle = findViewById(R.id.switch1);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    actionBar.show();
                } else {
                    actionBar.hide();
                }
            }
        });
        toggle.performClick();

        textView = findViewById(R.id.textView);
        registerForContextMenu(textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button을 Click했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                popupMenu.show();
                return false;
            }
        });
        popupMenu = new PopupMenu(this, button);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.buttonmenu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int check = menuItem.getItemId();
                if (check == R.id.itemBlack) {
                    button.setTextColor(Color.BLACK);
                } else if (check  == R.id.itemRed) {
                    button.setTextColor(Color.RED);
                } else {
                    button.setTextColor(Color.BLUE);
                }
                menuItem.setChecked(true);
                return true;
            }
        });

        editText = findViewById(R.id.editText);
        editText.setTextSize(18.0f);

        imageView = findViewById(R.id.imageView);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (actionMode != null) {
                    return false;
                }
                actionMode = startActionMode(callback);
                view.setSelected(true);
                return true;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        if (v == textView) {
            menu.setHeaderTitle("Text Menu");
            menu.setHeaderIcon(R.drawable.logo);
            if (codeflag) {
                inflater.inflate(R.menu.textmenu, menu);
            } else {
                menu.add(0, 1, 0, "글자색 검정").setChecked(true);
                menu.add(0, 2, 1, "글자색 빨강");
                menu.add(0, 3, 2, "글자색 파랑");
                menu.setGroupCheckable(0, true, true);
            }
            if (type == 1) {
                if (codeflag) {
                    menu.findItem(R.id.itemRed).setChecked(true);
                } else {
                    menu.findItem(2).setChecked(true);
                }
            } else if (type == 2) {
                if (codeflag) {
                    menu.findItem(R.id.itemBlue).setChecked(true);
                } else {
                    menu.findItem(3).setChecked(true);
                }
            }
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int check = item.getItemId();
        if (check == R.id.itemBlack) {
            textView.setTextColor(Color.BLACK);
            type = 0;
        } else if (check == R.id.itemRed) {
            textView.setTextColor(Color.RED);
            type = 1;
        } else {
            textView.setTextColor(Color.BLUE);
            type = 2;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int check = item.getItemId();
        if (check == R.id.item1) {
            ColorSetting colorSetting = new ColorSetting(actionBar, MainActivity.this);
            colorSetting.setColor();
        } else if (check == R.id.itemSizeDefault) {
            editText.setTextSize(18.0f);
        } else if (check == R.id.itemSizePlus) {
            editText.setTextSize(24.0f);
        } else if (check == R.id. itemSizeMinus) {
            editText.setTextSize(14.0f);
        }

        item.setChecked(true);
        return true;
    }

    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            MenuInflater inflater = actionMode.getMenuInflater();
            inflater.inflate(R.menu.imagemenu, menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            Bitmap bitmapFactory;
            int check = menuItem.getItemId();
            if (check == R.id.change) {
                if (flag) {
                    bitmapFactory = BitmapFactory.decodeResource(getResources(), R.drawable.an1);
                    flag = false;
                } else {
                    bitmapFactory = BitmapFactory.decodeResource(getResources(), R.drawable.picture);
                    flag = true;
                }
                imageView.setImageBitmap(Bitmap.createBitmap(bitmapFactory));
                return true;
            } else if (check == R.id.rotate) {
                imageView.setRotation(imageView.getRotation() + 45.0f);
            } else if (check == R.id.scale) {
                imageView.setScaleX(2.0f);
                imageView.setScaleY(2.0f);
            } else {
                imageView.setRotation(0.0f);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            actionMode = null;
        }
    };
}