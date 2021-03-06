package com.example.damien.realworldproject;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    private TextView mTVusername;
    private TextView mTVphone;

    private int id;
    private String username;
    private String phoneNo;

    public static final String USERNAME = "com.example.damien.realworldproject.USERNAME";
    public static final String PHONE = "com.example.damien.realworldproject.PHONE";
    public static final int REQUEST_CODE = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mTVusername = findViewById(R.id.TVusername);
        mTVphone = findViewById(R.id.TVphone);

        id = getIntent().getIntExtra(login.EXTRA_ID, -1);
        username = getIntent().getStringExtra(login.EXTRA_USERNAME);
        phoneNo = getIntent().getStringExtra(login.EXTRA_PHONE);

        mTVusername.setText("Username: " + username);
        mTVphone.setText("Phone No: " + phoneNo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                setResult(RESULT_OK, data);
                finish();
            }
        }
    }

    public void btnEditProfile_onClick(View view) {
        Intent i = new Intent(profile.this, editProfile.class);
        i.putExtra(login.EXTRA_ID, id);
        i.putExtra(profile.USERNAME, username);
        i.putExtra(profile.PHONE, phoneNo);
        startActivityForResult(i, REQUEST_CODE);
    }
}