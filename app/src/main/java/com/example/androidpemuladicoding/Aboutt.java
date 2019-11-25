package com.example.androidpemuladicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Aboutt extends AppCompatActivity implements View.OnClickListener {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutt);

    }

    @Override
    public void onClick(View view) {
        iv = findViewById(R.id.profile);
        Intent intent = new Intent(Aboutt.this, profile.class);
        startActivity(intent);
    }
}
