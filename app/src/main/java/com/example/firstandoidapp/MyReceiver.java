package com.example.firstandoidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Bundle b = intent.getExtras();
        String msg_from, msg_body;

        SmsMessage [] msgs = null;
        if( b != null)
        {
            try
            {
                Object [] p = (Object[]) b.get("pdus");
                msgs = new SmsMessage[p.length];
                for (int i=0;i<msgs.length;i++)
                {
                    msgs[i] = SmsMessage.createFromPdu((byte[]) p[i]);
                    msg_from = msgs[i].getOriginatingAddress();
                    msg_body = msgs[i].getMessageBody();

                    Toast.makeText(context, "SMS Arrived", Toast.LENGTH_SHORT).show();

                    Intent intent1 = new Intent(context,Confirm_otp.class);

                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent1.putExtra("mobile",msg_from);
                    intent1.putExtra("otp",msg_body);
                    context.startActivity(intent1);


                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }



    }
}
