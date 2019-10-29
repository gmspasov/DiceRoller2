package com.example.diceroller;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;


import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;

public class DiceView extends AppCompatImageView {

    Rect mRect;
    Paint mPaint;
    int mSquareColor;

    public DiceView(Context context) {
        super(context);
        init(null);

    }

    public DiceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DiceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)


    private void init(@Nullable AttributeSet set) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRect = new Rect();
        if (set == null) {
            return;
        }

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.DiceView);
        mSquareColor = ta.getColor(R.styleable.DiceView_square_color, Color.GREEN);
        mPaint.setColor(mSquareColor);
        ta.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.MAGENTA);
        mRect.left = 0;
        mRect.right = getWidth();
        mRect.top = 0;
        mRect.bottom = getHeight();

        canvas.drawRect(mRect, mPaint);
    }
}


