package deso1.doancaonhatha.dlu_2012353;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText eTxtTitle_Item, eTxtPrice_Item, eTxtUnit_Item;
    Button btnEdit_Item, btnDelete_Item;
    Integer itemPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
//        InitControl();
    }

//    void InitControl() {
//
//        eTxtTitle_Item = findViewById(R.id.eTxtTitle);
//        eTxtPrice_Item = findViewById(R.id.eTxtPrice_Item);
//        eTxtUnit_Item = findViewById(R.id.eTxtUnit_Item);
//        itemPos = Integer.parseInt(getIntent().getStringExtra("EXTRA_POS"));
//        eTxtTitle_Item.setText(getIntent().getStringExtra("EXTRA_TITLE"));
//        eTxtPrice_Item.setText(getIntent().getStringExtra("EXTRA_PRICE"));
//        eTxtUnit_Item.setText(getIntent().getStringExtra("EXTRA_UNIT"));
//
//
//        btnEdit_Item = findViewById(R.id.btnEdit);
//        btnEdit_Item.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("EXTRA_TITLE", eTxtTitle_Item.getText().toString());
//                returnIntent.putExtra("EXTRA_PRICE", eTxtPrice_Item.getText().toString());
//                returnIntent.putExtra("EXTRA_UNIT", eTxtUnit_Item.getText().toString());
//                returnIntent.putExtra("EXTRA_POS", itemPos+"");
//                returnIntent.putExtra("EXTRA_TYPE", "BTN_EDIT");
//                //returnIntent.putExtra("EXTRA_IMAGE", eTxtTitle.getText().toString());
//                setResult(Activity.RESULT_OK,returnIntent);
//                finish();
//            }
//        });
//
//        btnDelete_Item = findViewById(R.id.btnDelete);
//        btnDelete_Item.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Food food = new Food( 10 ,eTxtTitle_Item.getText().toString(), Integer.parseInt(eTxtPrice_Item.getText().toString()),eTxtUnit_Item.getText().toString(), R.drawable.bunbohue );
//                Intent returnIntent = new Intent();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("Xoa", food);
//                returnIntent.putExtras(bundle);
//                setResult(Activity.RESULT_OK,returnIntent);
//                finish();
//            }
//        });
//    }
}