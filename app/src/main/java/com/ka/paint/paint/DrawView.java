package com.ka.paint.paint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawView extends View {
    private PathProvider mPathProvider = new PathProvider();
    private int mCurrentColor = Color.BLACK;

    private float mCurX = 0f;
    private float mCurY = 0f;
    private float mStartX = 0f;
    private float mStartY = 0f;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setColor(mCurrentColor);
    }

    public void setColor(int color) {
        mCurrentColor = color;
    }

    public void clearCanvas() {
        mPathProvider.clear();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (PaintPath paintPath : mPathProvider.getAllPaths()){
            canvas.drawPath(paintPath.getPath(), paintPath.getPaint());
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = x;
                mStartY = y;
                actionDown(x, y);
                break;
            case MotionEvent.ACTION_MOVE: actionMove(x, y);
                break;
            case MotionEvent.ACTION_UP: actionUp();
                break;
        }

        invalidate();
        return true;
    }

    private void actionDown(float x, float y) {
        Path path = mPathProvider.getPath(mCurrentColor).getPath();

        path.moveTo(x, y);
        mCurX = x;
        mCurY = y;
    }

    private void actionMove(float x, float y) {
        Path path = mPathProvider.getPath(mCurrentColor).getPath();

        path.quadTo(mCurX, mCurY, (x + mCurX) / 2, (y + mCurY) / 2);

        mCurX = x;
        mCurY = y;
    }

    private void actionUp() {
        Path path = mPathProvider.getPath(mCurrentColor).getPath();

        path.lineTo(mCurX, mCurY);

        if (mStartX == mCurX && mStartY == mCurY) {
            path.lineTo(mCurX, mCurY + 2);
            path.lineTo(mCurX + 1, mCurY + 2);
            path.lineTo(mCurX + 1, mCurY);
        }
    }
}
