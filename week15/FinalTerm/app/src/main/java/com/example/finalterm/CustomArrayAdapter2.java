package com.example.finalterm;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomArrayAdapter2 extends ArrayAdapter<Member2> {
    private final Context context;
    private final List<Member2> members;
    private final Typeface customFont;

    public CustomArrayAdapter2(Context context, List<Member2> members) {
        super(context, R.layout.activity_list_item2, members);
        this.context = context;
        this.members = members;

        // 외부 TTF 파일 로드
        customFont = Typeface.createFromAsset(context.getAssets(), "fonts/custom_font.ttf");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_list_item2, parent, false);
        }

        // 현재 멤버 데이터 가져오기
        Member2 member = members.get(position);

        // 뷰 바인딩
        ImageView imageProfile = convertView.findViewById(R.id.image_profile);
        TextView tvName = convertView.findViewById(R.id.tv_name);
        TextView tvAge = convertView.findViewById(R.id.tv_age);
        TextView tvJob = convertView.findViewById(R.id.tv_job);

        // 데이터 설정
        imageProfile.setImageResource(member.getImageResId());
        tvName.setText(member.getName());
        tvAge.setText("(" + member.getAge() + "세)");
        tvJob.setText(member.getJob());

        // 폰트 설정
        tvName.setTypeface(customFont);
        tvAge.setTypeface(customFont);
        tvJob.setTypeface(customFont);

        return convertView;
    }
}
