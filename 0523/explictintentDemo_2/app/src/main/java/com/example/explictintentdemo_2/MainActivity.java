package com.example.explictintentdemo_2;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SET_RESULT = 1;
    TextView output;
    EditText txtOpd1, txtOpd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得TextView元件
        output = (TextView) findViewById(R.id.lblOutput);
        Button btn = (Button) findViewById(R.id.button);
        // Button元件的事件處理
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 取得EditText元件
                txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
                txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
                // 建立Intent物件
                Intent intent = new Intent(MainActivity.this, OpActivity.class);
                // 建立傳遞資料的Bundle物件
                Bundle bundle = new Bundle();
                bundle.putString("OPERAND01", txtOpd1.getText().toString());
                bundle.putString("OPERAND02", txtOpd2.getText().toString());
                intent.putExtras(bundle); // 加上資料
                // 啟動活動且有回傳資料
                startActivityForResult(intent, SET_RESULT);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case SET_RESULT:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    output.setText("計算結果: " + bundle.getDouble("RESULT"));
                }
                break;
        }
    }
}