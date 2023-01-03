package com.universe.lab1_bai2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    ImageView imgDices;
    Button btnRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRoll = findViewById(R.id.btnRoll);
        imgDices = findViewById(R.id.imgDices);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valus = randomDice();
                int res = getResources().getIdentifier("dice_" + valus, "drawable", "com.universe.lab1_bai2_2");
                imgDices.setImageResource(res);
            }
        });
    }
    public static int randomDice() {
        return RANDOM.nextInt(6) + 1;
    }
}