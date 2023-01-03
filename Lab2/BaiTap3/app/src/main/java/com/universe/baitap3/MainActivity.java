package com.universe.baitap3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView imgCall;
    TextView nbPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hook();
        checkAndRequest();
    }

    private void Hook(){
        imgCall = findViewById(R.id.imgCall);
        nbPhone = findViewById(R.id.nbPhone);

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCall();
            }
        });
    }

    private void intentCall(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + nbPhone.getText()));
        startActivity(intent);
    }

    private void checkAndRequest(){
        String[] permission = new String[]{
                Manifest.permission.CALL_PHONE
        };
    }
}