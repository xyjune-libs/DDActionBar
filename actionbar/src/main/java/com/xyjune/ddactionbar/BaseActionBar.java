package com.xyjune.ddactionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.IntDef;
import androidx.annotation.Nullable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BaseActionBar extends RelativeLayout {

    public static final int CENTER = 1;
    public static final int LEFT = 2;

    @IntDef({CENTER, LEFT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TitleGravity {
    }

    private TextView mTitle;

    public BaseActionBar(Context context) {
        this(context, null);
    }

    public BaseActionBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int padding = dip2px(context, 15);
        setPadding(padding, 0, padding, 0);
        initTitle();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BaseActionBar);
        String title = typedArray.getString(R.styleable.BaseActionBar_titleText);
        setTitle(title);
        int size = typedArray.getDimensionPixelSize(R.styleable.BaseActionBar_titleSize, sp2px(context, 16));
        mTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        int color = typedArray.getColor(R.styleable.BaseActionBar_titleColor, Color.parseColor("#333333"));
        setTitleColor(color);
        int gravity = typedArray.getInt(R.styleable.BaseActionBar_titleGravity, CENTER);
        setGravity(gravity);
        typedArray.recycle();
    }

    private void initTitle() {
        mTitle = new TextView(getContext());
        mTitle.setSingleLine();
        mTitle.setEllipsize(TextUtils.TruncateAt.END);
        mTitle.setMaxEms(10);
        mTitle.setTypeface(Typeface.DEFAULT_BOLD);
        addView(mTitle, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void setGravity(@TitleGravity int gravity) {
        LayoutParams layoutParams = (LayoutParams) mTitle.getLayoutParams();
        switch (gravity) {
            case CENTER:
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                break;
            case LEFT:
            default:
                layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_START);
                break;
        }
        mTitle.setLayoutParams(layoutParams);
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    public void setTitle(int titleId) {
        mTitle.setText(titleId);
    }

    public void setTitleSize(float size) {
        mTitle.setTextSize(size);
    }

    public void setTitleColor(int color) {
        mTitle.setTextColor(color);
    }

    protected int dip2px(Context context, int dip) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    protected int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
