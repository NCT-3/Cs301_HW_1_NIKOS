package com.example.cs301_hw_1;

import android.graphics.Paint;
import android.graphics.RectF;

public class DrawingElement {
    private String name;
    private Paint paint;
    private RectF bounds; // used for hit detection

    public DrawingElement(String name, int color, RectF bounds)
    {
        this.name = name;
        this.paint = new Paint();
        this.paint.setColor(color);
        this.bounds = bounds;
    }

    public String getName()
    {
        return name;
    }

    public Paint getPaint()
    {
        return paint;
    }

    public int getColor()
    {
        return paint.getColor();
    }

    public void setColor(int color)
    {
        paint.setColor(color);
    }

    public boolean contains(float x, float y)
    {
        return bounds.contains(x, y);
    }

    public RectF getBounds()
    {
        return bounds;
    }

}
