package com.example.coursetemplate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursetemplate.Adapters.ImageTextAdapter;
import com.example.coursetemplate.Adapters.ReasonFixesAdapter;
import com.example.coursetemplate.Interfaces.ExitDesignInterface;
import com.example.coursetemplate.Model.ReasonFix;

import java.util.ArrayList;
import java.util.List;

public class ExitDesign5 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, ExitDesignInterface {

    CheckBox[] ch = new CheckBox[6],ch2 = new CheckBox[6];
    ConstraintLayout  reasons;
    LinearLayout fixes;
    RecyclerView rcv1,rcv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit_desin5);
        fixes = findViewById(R.id.fixes);
        reasons = findViewById(R.id.reasons);
//        ch[0] = findViewById(R.id.cbReason11);
//        ch[1] = findViewById(R.id.cbReason21);
//        ch[2] = findViewById(R.id.cbReason31);
//        ch[3] = findViewById(R.id.cbReason41);
//        ch[4] = findViewById(R.id.cbReason51);
//        ch[5] = findViewById(R.id.cbReason61);

//        ch2[0] = findViewById(R.id.cbReason1);
//        ch2[1] = findViewById(R.id.cbReason2);
//        ch2[2] = findViewById(R.id.cbReason3);
//        ch2[3] = findViewById(R.id.cbReason4);
//        ch2[4] = findViewById(R.id.cbReason5);
//        ch2[5] = findViewById(R.id.cbReasonOther);

      //  for (int i=0; i<6;i++) {ch[i].setOnCheckedChangeListener(this);}
      //  findViewById(R.id.btnConfirmQuit).setOnClickListener(view -> {
        //         });

        findViewById(R.id.btnBack2).setOnClickListener(view -> {
            fixes.startAnimation(AnimationUtils.loadAnimation(this,R.anim.visibility_gone));
            fixes.setVisibility(View.GONE);
            reasons.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in_zoom_in));
        });

  //      findViewById(R.id.btnConfirmQuit2).setOnClickListener(view -> {
//        });
        rcv1 = findViewById(R.id.rcv1);
        rcv2 = findViewById(R.id.rcv2);
        List<ReasonFix> list = new ArrayList<>();
        List<ReasonFix> list2 = new ArrayList<>();
        list.add(new ReasonFix("Content is too difficult",R.drawable.difficult));
        list.add(new ReasonFix("Lack of time to study",R.drawable.stopwatch));
        list.add(new ReasonFix("Course is not interesting",R.drawable.technical));
        list.add(new ReasonFix("Found a better course",R.drawable.good));
        list.add(new ReasonFix("Technical issues",R.drawable.issue));
        rcv1.setAdapter(new ReasonFixesAdapter(R.layout.canelling_item,list,true,this));

        list2.add(new ReasonFix("Update the content",R.drawable.difficult));
        list2.add(new ReasonFix("Allow to watch courses offline",R.drawable.video_arrow_down_left));
        list2.add(new ReasonFix("Offer trending courses",R.drawable.good));
        list2.add(new ReasonFix("Offer a discount or special offer to incentivize staying",R.drawable.benefit_porcent));
        list2.add(new ReasonFix("Provide troubleshooting steps or a link to the technical support page",R.drawable.search));
        rcv2.setAdapter(new ReasonFixesAdapter(R.layout.canelling_item,list2,false,this));

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        //if (b)
            //findViewById(R.id.btnConfirmQuit).setEnabled(true);

    }

    @Override
    public void ShowLayout() {
        fixes.setVisibility(View.VISIBLE);
        fixes.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in_zoom_in));
    }

    @Override
    public void startNewAct() {
        startActivity(new Intent(ExitDesign5.this,ConfirmExit.class));
    }
}