package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox chkOriginal, chkBeef, chkSeafood;
    private Button button;
    private int[] chkIDs = {R.id.chkOriginal, R.id.chkBeef, R.id.chkSeafood};
    private String str, status;
    private TextView lblOutput, txtStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        chkOriginal = (CheckBox) findViewById(R.id.chkOriginal);
        chkBeef = (CheckBox) findViewById(R.id.chkBeef);
        chkSeafood = (CheckBox) findViewById(R.id.chkSeafood);
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        for(int id : chkIDs) {
            CheckBox chk = (CheckBox) findViewById(id);
            chk.setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        lblOutput = (TextView) findViewById(R.id.lblOutput);
//        Switch(buttonView.getId()) {
//            case R.id.chkOriginal:
//                lblOutput.setText("原味");
//            case R.id.chkBeef:
//                lblOutput.setText("牛肉");
//            case R.id.chkSeafood:
//                lblOutput.setText("海鮮");
//
//        }
        int id = buttonView.getId();
        str = "";
        status = "";
        if(id == R.id.chkOriginal) {
            status = (isChecked ? "選取" : "取消") + "原味";
        }
        if(id == R.id.chkBeef) {
            status = (isChecked ? "選取" : "取消") + "牛肉";
        }
        if(id == R.id.chkSeafood) {
            status = (isChecked ? "選取" : "取消") + "海鮮";
        }
        txtStatus.setText(status);
        for(int i : chkIDs) {
            CheckBox chk = (CheckBox) findViewById(i);
            if(chk.isChecked())
                str += chk.getText() + "\n";
        }

        lblOutput.setText(str);
    }
}