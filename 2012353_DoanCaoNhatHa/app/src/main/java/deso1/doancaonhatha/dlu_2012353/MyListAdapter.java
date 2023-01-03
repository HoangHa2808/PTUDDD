package deso1.doancaonhatha.dlu_2012353;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<Food> {
    private Activity context;
    private ArrayList<Food> list;
    private ArrayList<String> name;
    private ArrayList<String> price;
    private ArrayList<Integer> imgs;

    public MyListAdapter(Activity context, ArrayList list) {
        super(context, R.layout.activity_my_list, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_my_list, null, true);

        ImageView img = rowView.findViewById(R.id.ivFood);
        TextView name = rowView.findViewById(R.id.txtContent1);
        TextView price = rowView.findViewById(R.id.txtContent2);
        ImageButton imgButton = rowView.findViewById(R.id.ibEdit);
        img.setImageResource(this.list.get(position).getImg());
        name.setText(this.list.get(position).getName());
        price.setText("Giá: " + this.list.get(position).getPrice() + " đồng");

        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(parent.getContext(), EditActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                ((MainActivity)parent.getContext()).startActivity(intent);
            }
        });
        return rowView;
    }
}
