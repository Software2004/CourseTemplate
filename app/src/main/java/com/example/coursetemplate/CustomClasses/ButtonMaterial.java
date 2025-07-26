package com.example.coursetemplate.CustomClasses;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Html;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.coursetemplate.R;

public class ButtonMaterial extends LinearLayout {

    private TextView combinedTextView;
    private ImageView iconView;

    public ButtonMaterial(Context context) {
        super(context);
        init(context, null);
    }

    public ButtonMaterial(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ButtonMaterial(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setPadding(dpToPx(context, 25), dpToPx(context, 10), dpToPx(context, 25), dpToPx(context, 10));

        combinedTextView = new TextView(context);
        combinedTextView.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1));
        addView(combinedTextView);

        iconView = new ImageView(context);
        LayoutParams iconParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        iconParams.setMarginStart(dpToPx(context, 10));
        iconView.setLayoutParams(iconParams);
        addView(iconView);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ButtonMaterial, 0, 0);
            String titleText = a.getString(R.styleable.ButtonMaterial_title);
            String subtitleText = a.getString(R.styleable.ButtonMaterial_subtitle);
            int iconResId = a.getResourceId(R.styleable.ButtonMaterial_icon, -1);
            a.recycle();

            setText(titleText, subtitleText);
            setIcon(iconResId);
        }
    }

    public void setText(String title, String subtitle) {
        if (title != null && subtitle != null) {
            String formattedText = "<b>" + title + "</b><br/><small><small>" + subtitle + "</small></small>";
            combinedTextView.setText(Html.fromHtml(formattedText, Html.FROM_HTML_MODE_LEGACY));
            combinedTextView.setTextSize(18);
        }
    }

    public void setIcon(int resId) {
        if (resId != -1) {
            iconView.setImageResource(resId);
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }
    }

    private int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }
}
