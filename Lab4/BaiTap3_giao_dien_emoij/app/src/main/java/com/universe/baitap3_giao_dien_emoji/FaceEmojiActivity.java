package com.universe.baitap3_giao_dien_emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import com.universe.baitap3_giao_dien_emoij.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FaceEmojiActivity extends Fragment implements View.OnClickListener {
    private static final int[] ids = {R.id.iv_face1, R.id.iv_face2, R.id.iv_face3, R.id.iv_face4,
            R.id.iv_face5, R.id.iv_face6, R.id.iv_face7, R.id.iv_face8, R.id.iv_face9};

    private Context mContext;
    public static ArrayList arrRanDom;
    ImageButton btnRanDom;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.face_emoji, container, false);
        initViews(rootView);
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }
    private void initViews(View v) {
        for (int id : ids) {
            v.findViewById(id).setOnClickListener(this);
        }
    btnRanDom = (ImageButton) v.findViewById(R.id.btn_random);
        btnRanDom.setOnClickListener(this);

        String[] face = getResources().getStringArray(R.array.arr_face);
        arrRanDom = new ArrayList<>(Arrays.asList(face));
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_random:
                Collections.shuffle(arrRanDom);
                int idImage = getResources().getIdentifier((String) arrRanDom.get(15), "drawable", mContext.getPackageName());
               rdToast(idImage);
               break;
            default:
        ImageView ivFace = (ImageView) v;
        showToast(ivFace.getDrawable());
        break;
        }

    }
    private void showToast(Drawable drawable) {
        Toast toast = new Toast(mContext);
        ImageView ivEmoji = new ImageView(mContext);
        ivEmoji.setImageDrawable(drawable);
        toast.setView(ivEmoji);
        toast.show();
    }
    private void rdToast(int id){
        Toast toast = new Toast(mContext);
        ImageView ivEmoji = new ImageView(mContext);
        ivEmoji.setImageResource(id);
        toast.setView(ivEmoji);
        toast.show();
    }
}
