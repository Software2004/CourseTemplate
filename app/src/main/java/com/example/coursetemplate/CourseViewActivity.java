package com.example.coursetemplate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursetemplate.Adapters.CourseTitleAdapter;

public class CourseViewActivity extends AppCompatActivity {

    RecyclerView rcv;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_view);
        rcv = findViewById(R.id.rcv);
        rcv.setAdapter(new CourseTitleAdapter(this,R.layout.item_expandable_item));
        

    }
}