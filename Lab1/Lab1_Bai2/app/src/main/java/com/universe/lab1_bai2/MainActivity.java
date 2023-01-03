package com.universe.lab1_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtNumber;
    Button btnRandom;
    EditText txtA, txtB;
    TextView txtError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        // Random 1 con so
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = txtA.getText().toString();
                String b = txtB.getText().toString();

                // Yeu cau nguoi dung ko bo trong
                if (a.isEmpty()) {
                        txtError.setText("The first number is empty");
                        return;
                }else if(b.isEmpty()){
                    txtError.setText("The second number is empty");
                    return;
                }else{
                    txtError.setText("Processing");
                }
                // ep kieu du lieu chuoi -> so
                int min = Integer.parseInt(a);
                int max = Integer.parseInt(b);

                Random random = new Random();
                int number = random.nextInt(max - min + 1) + min;
                // Ep so -> chuoi
                txtNumber.setText(String.valueOf(number)); // number + "
            }
        });
    }

    private void AnhXa() {
        txtNumber = (TextView) findViewById(R.id.txtNumber);
        btnRandom = (Button) findViewById(R.id.btnRandom);
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtError = findViewById(R.id.error);
    }
}