package com.example.androidpemuladicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class profile extends AppCompatActivity {
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        foto = findViewById(R.id.fotoku);
//        foto.setImageResource(R.drawable.fadhil);
        Glide.with(this).load(R.drawable.fadhil).into(foto);
    }
}
