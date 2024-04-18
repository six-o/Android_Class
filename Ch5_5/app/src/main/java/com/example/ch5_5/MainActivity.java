package com.example.ch5_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private TextView lblOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblOutput = (TextView) findViewById(R.id.lblOutput);
        lblOutput.setTextSize(25);

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.activity_main);
        layout.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int act = event.getAction();
        switch (act) {
            case MotionEvent.ACTION_DOWN:
                lblOutput.setText("ACTION_DOWN");
                lblOutput.setTextColor(Color.RED);
                break;
            case MotionEvent.ACTION_UP:
                lblOutput.setText("ACTION_UP");
                lblOutput.setTextColor(Color.BLUE);
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();
                lblOutput.setText(String.format("ACTION_MOVE \n X = %.2f \n Y = %.2f", x,y));
                lblOutput.setTextColor(Color.GREEN);
                break;
        }
        return true;
    }


}