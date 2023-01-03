package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] items={"Android", "IOS", "WindowsPhone"};
    String[] contents={"Android is ...", "IOS is ...", "WindowsPhone is ..."};
    Integer[] images={R.drawable.android, R.drawable.ios, R.drawable.winphone};
    ListView lstMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inits();
        initCustomerLV();
    }
    private void initCustomerLV()
    {
        this.lstMain=findViewById(R.id.listviewMain);
        MyAdapter adapter=new MyAdapter(this.getApplicationContext(),
                0,
                this,
                items,
                contents,
                images);
        lstMain.setAdapter(adapter);


    }
    private  void Inits()
    {
        this.lstMain=findViewById(R.id.listviewMain);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        this.items);
        this.lstMain.setAdapter(myAdapter);

    }
}