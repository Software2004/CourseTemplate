package com.example.coursetemplate;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmExit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit_design5_confirm_cancel);

        findViewById(R.id.btnBack).setOnClickListener(view ->finish());


        findViewById(R.id.btnConfirmQuit).setOnClickListener(view -> {
            AppDialogBuilder passDialog = new AppDialogBuilder(this,R.layout.exit_dialog);
                passDialog.findViewById(R.id.btnNoLearn).setOnClickListener(view1 -> {
                    AppDialogBuilder confirmDialog = new AppDialogBuilder(this,R.layout.exit_design_dialog2_confirm);
                    showSpannableText(confirmDialog);

                    confirmDialog.findViewById(R.id.btnNoLearn).setOnClickListener(view2 -> {
                        AppDialogBuilder successDial = new AppDialogBuilder(this,R.layout.exit_design_dialog3_success);
                        successDial.switchToWindowContentView(true);
                        successDial.findViewById(R.id.btnConfirmQuit).setOnClickListener(view3 -> {
                            successDial.dismiss();
                            AppDialogBuilder successDial2 = new AppDialogBuilder(this,R.layout.exit_design_dialog3_success);
                            successDial2.switchToWindowContentView(true);
                            Button btnOk = successDial2.findViewById(R.id.btnConfirmQuit);
                            successDial2.findViewById(R.id.emailTxt).setVisibility(View.VISIBLE);
                            successDial2.findViewById(R.id.befEmailtxt).setVisibility(View.GONE);
                            btnOk.setText("Ok");
                            btnOk.setOnClickListener(view4 -> {
                                successDial2.dismiss();
                                finish();
                            });
                            successDial2.show();
                        });
                        successDial.show();
                        confirmDialog.dismiss();
                    });
                    confirmDialog.findViewById(R.id.btnConfirmQuit).setOnClickListener(view2 -> {
                    confirmDialog.dismiss();
                });
                confirmDialog.show();
                passDialog.dismiss();
            });
            passDialog.findViewById(R.id.btnConfirmQuit).setOnClickListener(view1 -> passDialog.dismiss());
            passDialog.show();
        });
    }

    private void showSpannableText(AppDialogBuilder confirmDialog) {
        CheckBox textView = confirmDialog.findViewById(R.id.cbReason1);

        SpannableStringBuilder spannableString = new SpannableStringBuilder("I accept the Terms & Conditions and Privacy Policy");

        // Bold text
        spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 13, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 36,50, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Underlined text
        spannableString.setSpan(new UnderlineSpan(), 13, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 36, 50, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Italic text
        //spannableString.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 24, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Colorful text
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.brand)), 13, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.brand)), 37, 50, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Clickable text
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Toast.makeText(ConfirmExit.this, "Terms & Conditions", Toast.LENGTH_SHORT).show();
            }
        };
        spannableString.setSpan(clickableSpan, 13, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan, 36, 50, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance()); // Makes the link clickable

    }
}