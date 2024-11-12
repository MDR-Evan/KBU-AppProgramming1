package com.example.week10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Report2_DialogFragment extends Fragment {

    private EditText edit;
    private RadioButton male;
    private RadioButton female;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_report2, container, false);

        edit = view.findViewById(R.id.name_edit_text);
        male = view.findViewById(R.id.male_radio_button);
        female = view.findViewById(R.id.female_radio_button);
        Button button = view.findViewById(R.id.confirm_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(getActivity(), "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    String gender = male.isChecked() ? "남자" : "여자";
                    Toast.makeText(getActivity(), name + " " + gender, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
