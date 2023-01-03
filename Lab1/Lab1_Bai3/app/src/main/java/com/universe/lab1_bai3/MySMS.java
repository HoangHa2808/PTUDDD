package com.universe.lab1_bai3;

import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MySMS extends Activity {
    Button btnSendSMS;
    EditText editSMS;
    TextView txtSendTo;

    @Override
    protected void onCreate (Bundle saveInstance){
        super.onCreate(saveInstance);
        setContentView(R.layout.activity_main_sms);
        btnSendSMS = findViewById(R.id.btnSendSMS);
        editSMS = findViewById(R.id.editSMS);
        txtSendTo = findViewById(R.id.txtSendTo);
        // Lay thong tin tu Intent
        Intent i = getIntent();
        Bundle b = i.getBundleExtra("DATA");
        final MyContact c = (MyContact) b.getSerializable("CONTACT");
        btnSendSMS.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMS(c);
            }
        });
        txtSendTo.setText("Send to: " + c.getPhone());
    }
    public void sendSMS(MyContact c)
    {
        //Lay default SmsManager
        final SmsManager sms = SmsManager.getDefault();
        Intent msgSent = new Intent("ACTION_MSG_SENT");

        final PendingIntent pen = PendingIntent.getBroadcast(this, 0, msgSent, 0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg = "Send OK";
                if (result!= Activity.RESULT_OK){
                    msg = "Send failed";
                }
                Toast.makeText(MySMS.this, msg, Toast.LENGTH_LONG).show();
            }
        }, new IntentFilter("ACTION_MSG_SENT"));

        sms.sendTextMessage(c.getPhone(),null, editSMS.getText() + "", pen, null );
        finish();
    }
}