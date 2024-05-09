package com.example.spinnerdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
private EditText txtOpd1, txtOpd2;
private TextView lblOutput;
private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
        txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
        lblOutput = (TextView) findViewById(R.id.lblOutput);
        spinner = (Spinner) findViewById(R.id.spinner);

//        txtOpd1.setText("100");
//        txtOpd2.setText("50");

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int v1, v2;
        double r = 0.0;
        try{
            v1 = Integer.parseInt(txtOpd1.getText().toString());
            v2 = Integer.parseInt(txtOpd2.getText().toString());
            switch(position) {
                case 0:
                    r = v1 + v2;
                    break;
                case 1:
                    r = v1 - v2;
                    break;
                case 2:
                    r = v1 * v2;
                    break;
                case 3:
                    if (v2 != 0) {
                        r = (double) v1 / v2;
                    } else {
                        throw new ArithmeticException();
                    }
                    break;
            }
            lblOutput.setText("運算結果 = " + String.format("%.2f", r));
        } catch (NumberFormatException e) {
            lblOutput.setText("請輸入數字");
            return;
        } catch (ArithmeticException e) {
            lblOutput.setText("除數不可為0");
            return;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}