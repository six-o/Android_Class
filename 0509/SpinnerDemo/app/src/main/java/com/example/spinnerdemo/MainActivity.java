package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Spinner spinner;
    private TextView lblOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] steaks = getResources().getStringArray(R.array.steaks);
                spinner = (Spinner) findViewById(R.id.spinner);
                int index = spinner.getSelectedItemPosition();
                lblOutput = (TextView) findViewById(R.id.lblOutput);
                lblOutput.setText("牛排 : " + steaks[index]);
//                lblOutput.setText("牛排 : " + spinner.getSelectedItem().toString());
            }
        });
    }
}