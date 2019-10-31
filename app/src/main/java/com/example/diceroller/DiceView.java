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

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;

import java.util.Random;

public class DiceImageView extends AppCompatImageView {




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
    }


    private void rolldice() {

        Random rnd = new Random();
        int randomInt = rnd.nextInt(6) + 1;

        switch (randomInt) {
            case 1:
                setImageResource(R.drawable.dice1);
                break;

            case 2:
                setImageResource(R.drawable.dice2);
                break;

            case 3:
                setImageResource(R.drawable.dice3);
                break;

            case 4:
                setImageResource(R.drawable.dice4);
                break;

            case 5:
                setImageResource(R.drawable.dice5);
                break;

            case 6:
                setImageResource(R.drawable.dice6);
                break;
        }
    }

    @Override
    public boolean performClick() {
        rolldice();
        return super.performClick();
    }
}


