package com.example.explictintentdemo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factivity);

        convertTemperature();

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void convertTemperature() {
        int c;
        double f = 0.0;
        String Place = "";
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            c = bundle.getInt("tempC", 0);
            f = (9.0 * c) / 5.0 + 32.0;
            Place = bundle.getString("Place", "");
            TextView txtF = (TextView) findViewById(R.id.lblOutput);
            txtF.setText(Place + "\n華氏溫度 : " + Double.toString(f));
        }
    }
}