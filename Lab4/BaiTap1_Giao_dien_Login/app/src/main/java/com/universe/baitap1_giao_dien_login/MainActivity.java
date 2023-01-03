package com.universe.baitap1_giao_dien_login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtLogin;
    EditText editMail;
    EditText editPass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = (TextView) findViewById(R.id.txtLogin);
        editMail = (EditText) findViewById(R.id.editEmail);
        editPass = (EditText) findViewById(R.id.editPassword);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Ban da dang nhap thanh cong voi email: " + editMail.getText() + " va mat khau: " + editPass.getText(), Toast.LENGTH_LONG);
                toast.show();

            }
        });
    }

}