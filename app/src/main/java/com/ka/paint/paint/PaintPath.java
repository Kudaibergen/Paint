package com.ka.paint.paint;

import android.graphics.Paint;
import android.graphics.Path;

// Created by askar on 9/1/18.
public class PaintPath {
    private Path path;
    private Paint paint;

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
