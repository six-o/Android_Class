package com.example.ch5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private float original_size = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtOutput = (TextView) findViewById(R.id.txtOutput);
        txtOutput.setTextSize(original_size);
        Button btnEnlarge = (Button) findViewById(R.id.btnEnlarge);
        btnEnlarge.setOnClickListener(this);
        btnEnlarge.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView txtOutput = (TextView) findViewById(R.id.txtOutput);
        float size = txtOutput.getTextSize();
        Log.v("SIZE", "size = " + size);
        txtOutput.setTextSize(size + 1);
    }

    @Override
    public boolean onLongClick(View v) {
        TextView txtOutput = (TextView) findViewById(R.id.txtOutput);
        txtOutput.setTextSize(original_size);
        return false;
    }
}