package com.example.raddiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.net.Proxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputString = "";
                RadioButton radioBoy = (RadioButton) findViewById(R.id.rdbBoy);
                RadioButton radioGirl = (RadioButton) findViewById(R.id.rdbGirl);
                if(radioBoy.isChecked()) {
                    outputString += "男生\n";
                }
                else if(radioGirl.isChecked()) {
                    outputString += "女生\n";
                }
                RadioGroup type = (RadioGroup) findViewById(R.id.rgType);
//                switch(type.getCheckedRadioButtonId()) {
//                    case R.id.rdbAdult:
//                        outputString += "全票";
//                        break;
//                    case R.id.rdbChild:
//                        outputString += "兒童票";
//                        break;
//                    case R.id.rdbStudent:
//                        outputString += "學生票";
//                        break;
//                }
                if(type.getCheckedRadioButtonId() == R.id.rdbAdult) {
                    outputString += "全票\n";
                } else if(type.getCheckedRadioButtonId() == R.id.rdbChild) {
                    outputString += "兒童票\n";
                } else {
                    outputString += "學生票\n";
                }
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(outputString);
            }
        });
    }
}