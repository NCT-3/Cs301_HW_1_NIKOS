//@author: Nikos
package com.example.cs301_hw_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class ObjectView extends SurfaceView
{
Paint housePaint = new Paint();
Paint windowPaint = new Paint();
Paint doorPaint = new Paint();
Paint sunPaint = new Paint();
Paint chimneyPaint = new Paint();
Paint roofPaint = new Paint();


    public ObjectView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);

        roofPaint.setColor(0xFFFF2020);//Roof colour red
        housePaint.setColor(0xFFFFFFFF);//house colour white
        windowPaint.setColor(0xFF87CEFA);//window color light blue
        doorPaint.setColor(0xFF8B4513);//Door colour brown
        sunPaint.setColor(0xFFFFFF00);//sun colour yellow
        chimneyPaint.setColor((0xFF800080));//Chimney colour pink/purple

        setBackgroundColor(Color.BLUE);//sets background colour
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(200, 500, 600, 900, housePaint);//draws house

        //  draws Roof
        Path roof = new Path();
        roof.moveTo(200, 500);  // left corner
        roof.lineTo(600, 500);  // right corner
        roof.lineTo(400, 300);  // peak
        roof.close();
        canvas.drawPath(roof, roofPaint);

        canvas.drawRect(350, 700, 450, 900, doorPaint);//draw door


        canvas.drawRect(250, 600, 320, 670, windowPaint);//draw left window


        canvas.drawRect(480, 600, 550, 670, windowPaint);//draw right window


        canvas.drawRect(500, 350, 540, 480, chimneyPaint);// draw chimney


        canvas.drawCircle(700, 200, 80, sunPaint);//draw sun
    }
}
