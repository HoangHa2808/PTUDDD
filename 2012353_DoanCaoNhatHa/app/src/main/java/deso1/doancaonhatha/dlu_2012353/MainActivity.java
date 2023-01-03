package deso1.doancaonhatha.dlu_2012353;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addFood;
    ImageView ivImg;
    ListView lvMain;
    ArrayList<Food> list = new ArrayList<Food>();
    MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(new Food(1, "Bún bò Huế", 120000, "Tô", R.drawable.bunbohue));
        list.add(new Food(2, "Thịt dê cơm cháy", 200000, "Phần", R.drawable.comchaythitde));
        list.add(new Food(3, "Lẩu gà lá é", 150000, "Phần", R.drawable.lauga));
        list.add(new Food(4, "Mì Quảng", 80000, "Tô", R.drawable.miquang));
        list.add(new Food(5, "Chè đậu đen", 20000, "Ly", R.drawable.chedauden));

        adapter = new MyListAdapter(this, this.list);
        lvMain = findViewById(R.id.lvMain);
        lvMain.setAdapter(adapter);

        addFood = findViewById(R.id.btnAdd);
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 &&  data !=null){
            Bundle bundle = data.getExtras();
            Food food = (Food) bundle.getSerializable("Them");
            list.add(food);
            adapter.notifyDataSetChanged();
        }
    }
}