package com.example.week10;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Report1_F extends ListFragment {
    String[] planet = new String[]{"Sun", "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
    ListView listView;
    private TextView textView;

    public Report1_F(){}

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, planet);
        setListAdapter(adapter);
        listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        listView.setItemChecked(position, true);

        settext();

        Toast.makeText(getActivity(), planet[position] + "이(가) 선택되었습니다.", Toast.LENGTH_SHORT).show();
    }

    private void settext() {
        int check = listView.getId();
        if (check == 1) {
            textView.setText("태양");
        }
    }
}