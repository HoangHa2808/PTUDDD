package com.universe.baitap2_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btnVN, btnEN, btnFrn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }
    private void initUI() {

        btnVN = (Button) findViewById(R.id.btnVN);
        btnEN = (Button) findViewById(R.id.btnEnglish);
        btnFrn = (Button) findViewById(R.id.btnFrancais);

        btnVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguage("vi", "VN");
            }
        });

        btnEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguage("en", "US");
            }
        });

        btnFrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguage("frn", "FR");
            }
        });
    }
    public void changeLanguage(String language, String lan){
        Locale locale = new Locale(language,lan);
        Configuration config = new Configuration();
        config.locale = locale;

        getBaseContext().getResources().updateConfiguration(
                config, getBaseContext().getResources().getDisplayMetrics()
        );

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}