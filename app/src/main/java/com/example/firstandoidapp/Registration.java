package com.example.firstandoidapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText e, e1, e2, e3, e4;

    CheckBox ch;

    Button b;

    AlertDialog.Builder ad;
    //SharedPreferences sp;
   // SharedPreferences.Editor ed;
    DataBase_Helper dataBase_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        e = findViewById(R.id.fname);
        e1 = findViewById(R.id.lname);
        e2 = findViewById(R.id.phone);
        e3 = findViewById(R.id.pass);
        e4 = findViewById(R.id.cpass);

        b = findViewById(R.id.button5);
        ch = findViewById(R.id.checkBox2);

        ActivityCompat.requestPermissions(Registration.this, new String[]
                        {Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS},1);


        //sp = getSharedPreferences("myDetails", MODE_PRIVATE);
        //ed = sp.edit();

        dataBase_helper = new DataBase_Helper(Registration.this);
    }

    public void Reset_method(View view) {

        e.setText("");
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");

    }

    public void Register_Method(View view) {

        // b.setEnabled(false);

        String s1 = e.getText().toString();
        String s2 = e1.getText().toString();
        String s3 = e2.getText().toString();
        String s4 = e3.getText().toString();
        String s5 = e4.getText().toString();



            if (!s4.equals(s5) || s4.isEmpty() || s5.isEmpty()) {

                ad = new AlertDialog.Builder(Registration.this);
                ad.setMessage("Password & Confirm Password Not Match or Empty!!");
                ad.setTitle("Error");
                ad.setIcon(android.R.drawable.ic_dialog_info);
                ad.setNegativeButton("Re-enter", null);
                ad.show();
            }
            else
             {

                if(ch.isChecked())
                {

                    SmsManager sm = SmsManager.getDefault();
                    String otp_Content = "HI, the OTP for the mY First App is : 123456";
                    sm.sendTextMessage(s3,null,otp_Content,null,null);

                    Toast.makeText(this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();

                    Intent i1 = new Intent(Registration.this, Confirm_otp.class);
                    startActivity(i1);



//                dataBase_helper.SaveDetails(s1, s2, s3, s4);
//
//                AlertDialog.Builder ad = new AlertDialog.Builder(Registration.this);
//                ad.setTitle("Info");
//                ad.setMessage("Credentials Saved");
//                ad.setPositiveButton("Back to Login", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Intent i2 = new Intent(Registration.this, Dashboard.class);
//                        startActivity(i2);
//                    }
//                });
//                ad.setIcon(android.R.drawable.ic_dialog_info);
//                ad.show();
            }

                else
                {
                    AlertDialog.Builder ad = new AlertDialog.Builder(Registration.this);
                    ad.setTitle("Error");
                    ad.setMessage("Please Agree to the Terms");
                    ad.setPositiveButton("Ok",null);

                    ad.setIcon(android.R.drawable.ic_dialog_info);
                    ad.show();
                }
        }



    }

}