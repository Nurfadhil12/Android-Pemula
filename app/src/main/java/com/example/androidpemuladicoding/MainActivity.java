package com.example.androidpemuladicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String[] titleData;
    String[] infoData;
    TypedArray imageData;
    Adapter adapter;
    RecyclerView sejajar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button iv = findViewById(R.id.imageView2);
        iv.setOnClickListener(this);
        sejajar = findViewById(R.id.sejajar);
        adapter = new Adapter(this);
        sejajar.setHasFixedSize(true);
        sejajar.setAdapter(adapter);
        sejajar.setLayoutManager(new LinearLayoutManager(this));

        prepare();
        addItem();

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Items mItems = new Items();
                mItems.setImage(imageData.getResourceId(position, -1));
                mItems.setTitle(titleData[position]);
                mItems.setInfo(infoData[position]);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("data", mItems);
                startActivity(intent);
            }
        });
    }

    public void prepare() {
        titleData = getResources().getStringArray(R.array.destination_name);
        infoData = getResources().getStringArray(R.array.destination_info);
        imageData = getResources().obtainTypedArray(R.array.destination_image);
    }

    public void addItem() {
        ArrayList<Items> mItems = new ArrayList<>();

        for (int i = 0; i < titleData.length; i++) {
            Items destination = new Items();
            destination.setImage(imageData.getResourceId(i, -1));
            destination.setTitle(titleData[i]);
            destination.setInfo(infoData[i]);
            mItems.add(destination);
        }
        adapter.setMovieItems(mItems);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageView2:
                Intent moveIntent = new Intent(MainActivity.this,profile.class);
                startActivity(moveIntent);
                break;
        }

    }
}