package deso1.doancaonhatha.dlu_2012353;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] items={"Bún bò Huế","Thịt dê cơm cháy","Lẩu gà lá é","Chè đậu đen"};
    String[] contents={"Giá 120.000 đồng","Giá 150.000 đồng","Giá 100.000 đồng","Giá 20.000 đồng"};
    Integer[] imgs={R.drawable.bunbohue,R.drawable.comchaythitde,R.drawable.lauga,R.drawable.miquang};
    ListView lsMain;
    private void innit() {
        lsMain = findViewById(R.id.foodListView);
        final FoodAdapter food=new
                FoodAdapter(this,items,contents,imgs);
        lsMain.setAdapter(food);
        lsMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = food.getItem(i);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innit();
    }
}