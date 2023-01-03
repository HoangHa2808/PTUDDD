package com.universe.lab1_bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editName, editPhone;
    Button btnSave;
    ListView lvContact;
    // Danh sach contact de dua vao ListView
    ArrayList<MyContact> arrContact = new ArrayList<MyContact>();
    ContactAdapter adapter = null;
    MyContact sclContact = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_main_sms);
        doGetFormWidgets();
        doAddEvents();
    }

    public void doGetFormWidgets() {
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        btnSave = findViewById(R.id.btnSave);
        lvContact = findViewById(R.id.lvContact);

        // Tao doi tuong adapter
        adapter = new ContactAdapter(this, arrContact);
        lvContact.setAdapter(adapter);
        //Thiet lap context menu cho ListView
        registerForContextMenu(lvContact);
    }

    public void doAddEvents() {
        btnSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                doSaveContact();
            }
        });
        // Lay contact dc chon trong ListView
        // Khi mo context menu se lam mat focus nen phai luu lai trc
        lvContact.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View v, int i, long l) {
                sclContact = arrContact.get(i);
                return false;
            }
        });
    }

    // Moi lan nhan Save thi goi ham nay, cap nhat contact vao ListView, chi luu trong bo nho
    public void doSaveContact() {
        MyContact ct = new MyContact();
        ct.setName(editName.getText() + "");
        ct.setPhone(editPhone.getText() + "");
        arrContact.add(ct);
        adapter.notifyDataSetChanged();
    }

@Override
        public void onCreateContextMenu( ContextMenu menu, View v, ContextMenuInfo Info){
        super.onCreateContextMenu(menu, v, Info);
        //Gan context menu vao
        getMenuInflater().inflate(R.menu.phonecontext, menu);
        menu.setHeaderTitle("Call - SMS");
        menu.getItem(0).setTitle("Call to "+ sclContact.getPhone());
        menu.getItem(1).setTitle("Send sms to "+ sclContact.getPhone());
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //kiểm tra xem Menu Item nào được chọn
        switch(item.getItemId())
        {
            case R.id.call:
                doMakeCall();
                break;
            case R.id.sms:
                doMakeSms();
                break;
            case R.id.remove:
                arrContact.remove(sclContact);
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }
    // GOI DIEN THOAI
    public void doMakeCall() {
        Uri uri = Uri.parse("Tel: " + sclContact.getPhone());
        Intent i = new Intent(Intent.ACTION_CALL, uri);
        startActivity(i);
    }

    public void doMakeSms() {
//        Uri uri = Uri.parse("Tel: " + sclContact.getPhone());
//        Intent i = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(i);
        Intent i = new Intent(this, MySMS.class);
        Bundle b = new Bundle();
        b.putSerializable("CONTACT", sclContact);
        i.putExtra("DATA", b);
        startActivity(i);
    }
}