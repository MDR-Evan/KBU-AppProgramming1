package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentB extends Fragment {
    private int flag;

    public FragmentB() {

    }

    public FragmentB(int flag) {
        this.flag = flag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        if (flag == 1) {
            view = inflater.inflate(R.layout.fragment_b, container, false);
        } else if (flag == 2) {
            view = inflater.inflate(R.layout.fragment_bb, container, false);
        } else {
            view = inflater.inflate(R.layout.fragment_bbb, container, false);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "확인", Toast.LENGTH_SHORT).show();
            }
        });

    }
}