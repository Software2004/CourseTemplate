package com.example.coursetemplate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursetemplate.Adapters.ImageTextAdapter;
import com.google.android.material.imageview.ShapeableImageView;

public class HomeActivity extends AppCompatActivity {

    TextView tvName;
    ShapeableImageView profileIcon;
    RecyclerView rcvGrid,rcvHori;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvName = findViewById(R.id.text);
        profileIcon = findViewById(R.id.icon);
        rcvGrid = findViewById(R.id.tabWelcomeItems);
        rcvHori = findViewById(R.id.nav_items);
        tvName.setText("Aun Alvi");
        profileIcon.setImageResource(R.drawable.ic_launcher_foreground);
        profileIcon.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));

        findViewById(R.id.profil).setOnClickListener(view -> startActivity(new Intent(HomeActivity.this,CourseViewActivity.class)));

        rcvGrid.setAdapter(new ImageTextAdapter(R.layout.nav_list_item_alt));
        rcvHori.setAdapter(new ImageTextAdapter(R.layout.nav_list_item));


    }
}