package com.example.ch5_3;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private float original_size = 30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtOutput = (TextView) findViewById(R.id.txtOutput);
        txtOutput.setTextSize(TypedValue.COMPLEX_UNIT_PX, original_size);
        Log.v("SIZE", "initializeSize = " +original_size + " px");
        Button btnEnlarge = (Button) findViewById(R.id.btnEnlarge);
        btnEnlarge.setOnClickListener(this);
        btnEnlarge.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView txtOutput = (TextView) findViewById(R.id.txtOutput);
        float size = txtOutput.getTextSize();
        float newSize = size + 10; // 假設增加 10 個像素
        Log.v("SIZE", "size = " + newSize + " px");
        txtOutput.setTextSize(TypedValue.COMPLEX_UNIT_PX, newSize);
    }

    @Override
    public boolean onLongClick(View v) {
        TextView txtOutput = (TextView) findViewById(R.id.txtOutput);
        Log.v("SIZE", "size = " +original_size + " px");
        txtOutput.setTextSize(TypedValue.COMPLEX_UNIT_PX, original_size);
        return false;
    }
}