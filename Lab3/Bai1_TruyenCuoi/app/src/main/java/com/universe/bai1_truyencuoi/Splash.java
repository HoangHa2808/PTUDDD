package com.universe.bai1_truyencuoi;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Splash extends Fragment{
    @Override

    public View onCreteView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        initView();
        return inflater.inflate(R.layout.splash, container, false);
    }
    private void initView(){
        new Handler().postDelayed(this::gotoSplash, 2000);
    }
    private void gotoSplash(){
        ((MainActivity)getActivity()).gotoSplash();
    }
}
