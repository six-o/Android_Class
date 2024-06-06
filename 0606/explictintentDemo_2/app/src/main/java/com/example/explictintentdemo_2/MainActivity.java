package com.example.explictintentdemo_2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SET_RESULT = 1;
    private TextView output;
    private EditText txtOpd1, txtOpd2;
    ActivityResultLauncher launcher = registerForActivityResult(new ResultContract(),
            new ActivityResultCallback<String>() {
                @Override
                public void onActivityResult(String o) {
                    output.setText("計算結果: " + o);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得TextView元件
        output = (TextView) findViewById(R.id.lblOutput);
        txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
        txtOpd2 = (EditText) findViewById(R.id.txtOpd2);

        Button btn = (Button) findViewById(R.id.button);
        // Button元件的事件處理
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher.launch(true);
            }
        });
    }
    class ResultContract extends ActivityResultContract<Boolean, String> {
        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, Boolean input) {
            Intent intent = new Intent(MainActivity.this, OpActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("OPERAND01", txtOpd1.getText().toString());
            bundle.putString("OPERAND02", txtOpd2.getText().toString());
            intent.putExtras(bundle);
            return intent;
        }
        @Override
        public String parseResult(int resultCode,@Nullable Intent intent) {
            Bundle bundle = intent.getExtras();
            Double result = bundle.getDouble("RESULT");
            return result.toString();
        }
    }
}