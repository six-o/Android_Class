package com.example.alertdialogmultchoisedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener

    private Button btnselect;
    private TextView output;
    private String[] items;
    private Boolean[] itemsChecked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnselect = (Button) findViewById(R.id.btnselect);
        output = (TextView) findViewById(R.id.lblOutput);

        String[] items = {"Samsung","OPPO","Apple","ASUS"};
        Boolean[] itemsChecked = {false, false, false, false};

        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog Build = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("請勾選選項 : ")
                        .setPositiveButton("確定",MainActivity.this)
                        .setNegativeButton("取消",MainActivity.this)
                        .setMultiChoiceItems(items, itemsChecked, null)// 錯誤
                        .show();
            }
        });
    }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            String msg = "";
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    for (int i = 0; i < items.length; i++){
                        if (itemsChecked[i]){
                            msg += items[i] + "\n";
                        }
                    }
                    output.setText(msg);
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

}
