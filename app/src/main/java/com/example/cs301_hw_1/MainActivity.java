//@author: Nikos
package com.example.cs301_hw_1;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    SeekBar redBar, greenBar, blueBar;
    TextView currentElementText;
    ObjectView objectView;
    DrawingController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
            redBar = findViewById(R.id.leftSeekBar);
            greenBar = findViewById(R.id.centerSeekBar);
            blueBar = findViewById(R.id.rightSeekBar);
            currentElementText = findViewById(R.id.textView4);
            objectView = findViewById(R.id.objectview);

            controller = new DrawingController(currentElementText);
            objectView.setController(controller);

            SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b)
                {
                    controller.updateColorFromSeekBars(redBar.getProgress(),greenBar.getProgress(),blueBar.getProgress());
                    objectView.invalidate();
                }
                public void onStartTrackingTouch(SeekBar seekBar){}
                public void onStopTrackingTouch(SeekBar seekBar){}
            };

            redBar.setOnSeekBarChangeListener(listener);
            greenBar.setOnSeekBarChangeListener(listener);
            blueBar.setOnSeekBarChangeListener(listener);
    }
}