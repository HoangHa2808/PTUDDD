package deso1.doancaonhatha.dlu_2012353;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    Button btnAdd;
    EditText eTxtPrice, eTxtTitle, eTxtUnit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        InitControl();
    }

    void InitControl() {
        btnAdd = findViewById(R.id.btnAdd);
        eTxtTitle = findViewById(R.id.eTxtTitle);
        eTxtPrice = findViewById(R.id.eTxtPrice_Item);
        eTxtUnit = findViewById(R.id.eTxtUnit_Item);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Food food = new Food( 10 ,eTxtTitle.getText().toString(), Integer.parseInt(eTxtPrice.getText().toString()),eTxtUnit.getText().toString(), R.drawable.bunbohue );
                Intent returnIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("Them", food);
                returnIntent.putExtras(bundle);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }

}