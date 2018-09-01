package com.ka.paint.paint;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.Path;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// Created by askar on 9/1/18.
public class PathProvider {
    @SuppressLint("UseSparseArrays")
    private Map<Integer, PaintPath> pathMap = new HashMap<>();

    public void clear(){
        pathMap.clear();
    }

    public Collection<PaintPath> getAllPaths(){
        return pathMap.values();
    }

    private Paint getPaint(int color){
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(8f);
        paint.setAntiAlias(true);

        return paint;
    }

    public PaintPath getPath(int color){
        PaintPath path = pathMap.get(color);
        if (path != null) {
            return path;
        }

        Path path1 = new Path();
        Paint paint = getPaint(color);
        path = new PaintPath();
        path.setPaint(paint);
        path.setPath(path1);
        pathMap.put(color, path);

        return path;
    }
}
