package com.example.finalterm;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MemberDetailDialogFragment extends DialogFragment {

    private static final String ARG_NAME = "name";
    private static final String ARG_AGE = "age";
    private static final String ARG_JOB = "job";
    private static final String ARG_IMAGE_RES_ID = "image_res_id";

    public static MemberDetailDialogFragment newInstance(String name, int age, String job, int imageResId) {
        MemberDetailDialogFragment fragment = new MemberDetailDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putInt(ARG_AGE, age);
        args.putString(ARG_JOB, job);
        args.putInt(ARG_IMAGE_RES_ID, imageResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_member_detail, container, false);

        // 데이터 가져오기
        String name = getArguments().getString(ARG_NAME);
        int age = getArguments().getInt(ARG_AGE);
        String job = getArguments().getString(ARG_JOB);
        int imageResId = getArguments().getInt(ARG_IMAGE_RES_ID);

        // 뷰 바인딩
        ImageView imageView = view.findViewById(R.id.image_profile);
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvAge = view.findViewById(R.id.tv_age);
        TextView tvJob = view.findViewById(R.id.tv_job);
        Button btnClose = view.findViewById(R.id.btn_close);

        // 데이터 설정
        imageView.setImageResource(imageResId);
        tvName.setText(name);
        tvAge.setText("(" + age + "세)");
        tvJob.setText(job);

        // 닫기 버튼 이벤트
        btnClose.setOnClickListener(v -> {
            Log.d("DEBUG", "Close button clicked");
            dismiss(); // 다이얼로그 종료
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        // 다이얼로그 크기 설정
        if (getDialog() != null && getDialog().getWindow() != null) {
            WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
            params.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.8); // 너비 80%
            params.height = WindowManager.LayoutParams.WRAP_CONTENT; // 높이는 내용에 맞게
            getDialog().getWindow().setAttributes(params);
        }
    }
}
