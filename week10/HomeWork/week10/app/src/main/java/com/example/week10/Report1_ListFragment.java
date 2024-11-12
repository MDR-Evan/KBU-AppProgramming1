package com.example.week10;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class Report1_ListFragment extends ListFragment {

    private OnPlanetSelectedListener callback;
    private int selectedPosition = -1;

    public interface OnPlanetSelectedListener {
        void onPlanetSelected(String planet);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnPlanetSelectedListener) {
            callback = (OnPlanetSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnPlanetSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] planet = {"Sun", "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
        String[] planet_kor = {"태양", "수성", "금성", "지구", "화성", "목성", "토성", "천왕성", "해왕성", "명왕성"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, planet) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                if (position == selectedPosition) {
                    view.setBackgroundColor(0xFFFF0000);
                } else {
                    view.setBackgroundColor(0x00000000); // transparent color
                }
                return view;
            }
        };
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                String selectedPlanet = planet[position];
                String translatedPlanet = planet_kor[position];
                callback.onPlanetSelected(translatedPlanet);

                adapter.notifyDataSetChanged();
            }
        });
    }
}
