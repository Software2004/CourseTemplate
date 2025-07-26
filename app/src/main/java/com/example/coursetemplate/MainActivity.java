package com.example.coursetemplate;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Runnable runnable;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent(MainActivity.this, HomeActivity.class));
            }
        };
        handler = new Handler();
        handler.postDelayed(runnable,1000);
    }


    @NonNull
    @Override
    public OnBackInvokedDispatcher getOnBackInvokedDispatcher() {
        handler.removeCallbacks(runnable);
        return super.getOnBackInvokedDispatcher();
    }
}