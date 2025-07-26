package com.example.coursetemplate;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.coursetemplate.CustomClasses.ButtonMaterial;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_profile1);
        ButtonMaterial btn = (com.example.coursetemplate.CustomClasses.ButtonMaterial) findViewById(R.id.subscription);
       // btn.setText("Hello World","This is the subtitle");
        btn.setOnClickListener(view -> startActivity(new Intent(ProfileActivity.this, ExitDesign5.class)));
       }
}