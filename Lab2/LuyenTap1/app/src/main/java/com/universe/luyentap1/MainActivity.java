package com.universe.luyentap1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imgView;
    TextView txtView;
    LinearLayout layout;
    Animation anim;

    ProgressBar progressBar;
    private static int SPLAS = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random();

    }

    private void Random() {
        Random random = new Random();
        imgView = findViewById(R.id.imgView);
        txtView = findViewById(R.id.txtView);
        layout = findViewById(R.id.layout);
        progressBar = findViewById(R.id.progress);

        anim = AnimationUtils.loadAnimation(this, R.anim.anim);
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

        layout.setBackgroundColor(color);
        imgView.setAnimation(anim);
        txtView.setAnimation(anim);

//        Sprite circle = new Circle();
//        progressBar.setIndeterminateDrawable(circle);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Activity.class);
                startActivity(intent);
            }
        }, SPLAS);
    }
}