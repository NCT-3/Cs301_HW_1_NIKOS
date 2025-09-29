package com.example.cs301_hw_1;

import android.widget.SeekBar;
import android.widget.TextView;
import android.graphics.Color;

public class DrawingController
{

    private DrawingElement currentElement;
    private TextView elementNameText;

    public DrawingController(TextView elementNameText)
    {
        this.elementNameText = elementNameText;
    }

    public void setCurrentElement(DrawingElement element, SeekBar red, SeekBar green, SeekBar blue)
    {
        currentElement = element;
        elementNameText.setText(element.getName());

        int color = element.getColor();
        red.setProgress(Color.red(color));
        green.setProgress(Color.green(color));
        blue.setProgress(Color.blue(color));
    }

    public void updateColorFromSeekBars(int r, int g, int b)
    {
        if (currentElement != null)
        {
            currentElement.setColor(Color.rgb(r, g, b));
        }
    }

    public DrawingElement getCurrentElement()
    {
        return currentElement;
    }
}
