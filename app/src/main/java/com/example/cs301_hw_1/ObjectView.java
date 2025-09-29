//@author: Nikos
package com.example.cs301_hw_1;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.graphics.RectF;
import android.view.MotionEvent;
import java.util.ArrayList;


public class ObjectView extends SurfaceView
{

    private ArrayList<DrawingElement> elements = new ArrayList<>();
    private DrawingController controller;

    //Paint housePaint = new Paint();
   // Paint windowPaint = new Paint();
   // Paint doorPaint = new Paint();
    //Paint sunPaint = new Paint();
    //Paint chimneyPaint = new Paint();
    //Paint roofPaint = new Paint();


    public ObjectView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);

        //roofPaint.setColor(0xFFFF2020);//Roof colour red
       // housePaint.setColor(0xFFFFFFFF);//house colour white
       // windowPaint.setColor(0xFF87CEFA);//window color light blue
       // doorPaint.setColor(0xFF8B4513);//Door colour brown
        //sunPaint.setColor(0xFFFFFF00);//sun colour yellow
        //chimneyPaint.setColor((0xFF800080));//Chimney colour pink/purple
        setBackgroundColor(Color.BLUE);//sets background colour


        // Define elements with bounds for taps
        elements.add(new DrawingElement("House", Color.WHITE, new RectF(200, 500, 600, 900)));
        elements.add(new DrawingElement("Door", Color.rgb(139,69,19), new RectF(350, 700, 450, 900)));
        elements.add(new DrawingElement("Left Window", Color.rgb(135,206,250), new RectF(250, 600, 320, 670)));
        elements.add(new DrawingElement("Right Window", Color.rgb(135,206,250), new RectF(480, 600, 550, 670)));
        elements.add(new DrawingElement("Chimney", Color.rgb(128,0,128), new RectF(500, 350, 540, 480)));
        elements.add(new DrawingElement("Sun", Color.YELLOW, new RectF(620, 120, 780, 280)));


    }

    public void setController(DrawingController controller)
    {
        this.controller = controller;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (DrawingElement e : elements)
        {
            canvas.drawRect(e.getBounds(),e.getPaint());
        }
        //canvas.drawRect(200, 500, 600, 900, housePaint);//draws house

        //  draws Roof part
        Path roof = new Path();
        roof.moveTo(200, 500);  // left corner
        roof.lineTo(600, 500);  // right corner
        roof.lineTo(400, 300);  // peak
        roof.close();

        Paint roofPaint = new Paint();
        roofPaint.setColor(Color.RED);
        canvas.drawPath(roof, roofPaint);

        //canvas.drawPath(roof, roofPaint);
        //canvas.drawRect(350, 700, 450, 900, doorPaint);//draw door
        //canvas.drawRect(250, 600, 320, 670, windowPaint);//draw left window
        //canvas.drawRect(480, 600, 550, 670, windowPaint);//draw right window
        //canvas.drawRect(500, 350, 540, 480, chimneyPaint);// draw chimney
        //canvas.drawCircle(700, 200, 80, sunPaint);//draw sun
    }
    public boolean onTouchEvent(MotionEvent event)
    {
        if(controller == null) return true;

        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            float x = event.getX();
            float y = event.getY();

            for(int i = elements.size()-1; i >= 0;  i--)//reverse loop because normal loop was making house get checked and door + window would never get checked
            {
                DrawingElement e = elements.get(i);
                if(e.contains(x,y))
                {
                    controller.setCurrentElement(e, ((MainActivity) getContext()).redBar, ((MainActivity) getContext()).greenBar, ((MainActivity) getContext()).blueBar);
                    invalidate(); // redraws
                    break;
                }
            }
        }
        return true;
    }

}
