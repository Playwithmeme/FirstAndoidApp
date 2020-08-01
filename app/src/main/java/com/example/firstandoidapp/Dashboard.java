package com.example.firstandoidapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {


    EditText e,e1;
    String username, password;
    String sp_username, sp_password;

    DataBase_Helper dataBase_helper;

    AlertDialog.Builder ad;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        e =  findViewById(R.id.username);
        e1 =  findViewById(R.id.pass);

        dataBase_helper = new DataBase_Helper(Dashboard.this);
    }

    public void Register(View view) {

        Intent register = new Intent(Dashboard.this, Registration.class);
        startActivity(register);
    }

    public void SignIn(View view) {

        username = e.getText().toString();
        password = e1.getText().toString();





        sp_password = dataBase_helper.getDetails(username);
       // sp_password = sp2.getString("password","password");



        if( password.equals(sp_password))
        {
           Intent i2 = new Intent(Dashboard.this,Success.class);
           startActivity(i2);
        }
        else
        {
            ad = new AlertDialog.Builder(Dashboard.this);
            ad.setMessage("Invaliid Credentials!!");
            ad.setTitle("Error");
            ad.setIcon(android.R.drawable.ic_dialog_info);
            ad.setNegativeButton("Re-enter", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent i1 = new Intent(Dashboard.this, Dashboard.class);
                    startActivity(i1);
                }
            });
            ad.show();
        }

    }


}