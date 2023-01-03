package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] items={"Android","iOS","Blackbery","Window Phone","Symblan"};
    String[] contents={"Android","iOS","Blackbery","Window Phone","Symblan"};
    Integer[] imgs={R.drawable.android,R.drawable.apple,R.drawable.blackberry,R.drawable.windowphone,R.drawable.symbian};
    ListView lsMain;
    private void innit() {
        lsMain = findViewById(R.id.list_view);
        final MyListAdapter adapter=new
                MyListAdapter(this,items,contents,imgs);
        lsMain.setAdapter(adapter);
        lsMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapter.getItem(i);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
            }
        });
    }
//    ListView lsMain;
//    private void innit(){
//        String[] items={"Android","iOS","Blackbery","Window Phone","Symblan"};
//        String[] contents={"Android","iOS","Blackbery","Window Phone","Symblan"};
//        Integer[] imgs={R.drawable.android,R.drawable.apple,R.drawable.blackberry,R.drawable.windowphone,R.drawable.blackberry};
//        final MyListAdapter adapter=new
//                MyListAdapter(this,items,contents,imgs);
//        lsMain.setAdapter(adapter);
//        lsMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String value=adapter.getItem(i);
//                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG).show();
//            }
//        });
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innit();
    }
}
