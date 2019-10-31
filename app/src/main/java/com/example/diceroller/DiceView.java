package com.example.diceroller;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Random;



public class DiceView extends View {


    private Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dice1);
    private Matrix m = new Matrix();
    float scaleWidth = 100/640f;
    float scaleHeight = 100/632f;

    public DiceView(Context context) {
        super(context);
        init(null);
    }

    public DiceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DiceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);;
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)


    private void init(@Nullable AttributeSet set) {
        m.postScale(scaleWidth,scaleHeight);
         //this.getLayoutParams().width=100;
        // this.getLayoutParams().height=100;
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
        invalidate();
        rolldice();
        return super.performClick();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, m, null);
    }

}


