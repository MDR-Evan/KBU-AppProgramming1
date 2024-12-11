package com.example.finalterm;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class SimpleList1_Fragment extends ListFragment {

    private OnPlanetSelectedListener callback;

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // res/values/arrays.xml에서 데이터 로드
        String[] members = getResources().getStringArray(R.array.member);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireActivity(),
                android.R.layout.simple_list_item_1,
                members
        );
        setListAdapter(adapter);

        // 리스트 클릭 이벤트 설정
        getListView().setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = members[position];

            // Toast로 선택된 항목 출력
            Toast.makeText(getActivity(), selectedItem, Toast.LENGTH_SHORT).show();

            // 선택된 항목을 Activity로 전달
            if (callback != null) {
                callback.onPlanetSelected(selectedItem);
            }
        });
    }


}
