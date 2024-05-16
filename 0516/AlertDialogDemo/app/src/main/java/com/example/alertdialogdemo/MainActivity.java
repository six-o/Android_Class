package com.example.alertdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private Button btnShowDialog, btnEnd, btnColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDialog = (Button) findViewById(R.id.btnShowDialog);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        btnColor = (Button) findViewById(R.id.btnColor);

        btnShowDialog.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("關於本書")
                    .setMessage("Android程式設計與應用\n作者 : 陳會安\n教師 : 恰克虎")
                    .setCancelable(true)
                    .setPositiveButton("確定", null)
                    .show();
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("確認")
                        .setMessage("確定要結束本程式嗎?")
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "按下取消鈕!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("選擇背景顏色")
                        .setItems(new String[]{"紅色", "綠色", "藍色"}, MainActivity.this)
                        .setNegativeButton("取消", MainActivity.this)
                        .show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case 0:
                btnColor.setBackgroundColor(Color.RED);
                break;
            case 1:
                btnColor.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                btnColor.setBackgroundColor(Color.BLUE);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(MainActivity.this, "按下取消鈕!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}