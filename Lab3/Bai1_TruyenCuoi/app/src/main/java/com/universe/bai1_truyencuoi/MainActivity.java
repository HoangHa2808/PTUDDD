package com.universe.bai1_truyencuoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String topicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFrg(new Splash());
    }

    private void showFrg(Fragment frg) {
        getSupportFragmentManager().beginTransaction().replace(R.id.In_main, frg, null).commit();
    }

    public void gotoSplash() {
    }

    public void gotoSplash2(String topicName) {
    }

    public void backToSplash() {
        gotoSplash();
    }

    public void gotoSplash3(ArrayList<StoryEntity> listStory, StoryEntity story) {
    }
}