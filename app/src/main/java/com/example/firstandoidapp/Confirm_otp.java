package com.example.firstandoidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.widget.EditText;

public class Confirm_otp extends AppCompatActivity {

    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_otp);

        e = findViewById(R.id.editTextTextPersonName);

        ActivityCompat.requestPermissions(Confirm_otp.this, new String[] {
                Manifest.permission.RECEIVE_SMS},1);



        e.setText(getIntent().getStringExtra("otp"));
    }
}