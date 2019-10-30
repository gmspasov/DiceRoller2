package com.example.diceroller;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Random;

public class DiceView extends View {

private         Bitmap                  bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dice1);
private Matrix m=new Matrix();
    ;



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



    private void rolldice() {

        Random rnd = new Random();
        int randomInt = rnd.nextInt(6) + 1;

        switch (randomInt) {
            case 1:
                 bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dice1);
                break;

            case 2:
                 bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dice2);
                break;

            case 3:
                 bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dice3);
                break;

            case 4:
                 bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dice4);
                break;

            case 5:
                 bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dice5);
                break;

            case 6:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dice6);
                break;
        }
    }

    @Override
    public boolean performClick() {
        rolldice();
        invalidate();
        return super.performClick();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, m, null);
    }
}


