package com.example.spinneradapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] courses, desserts;
    private Spinner spCourse, spDesert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses = getResources().getStringArray(R.array.courses);
        desserts = getResources().getStringArray(R.array.desserts);

        spCourse = (Spinner) findViewById(R.id.spinner);
        spDesert = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> AdapterCourse = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, courses);
        ArrayAdapter<String> AdapterDessert = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, desserts);

        spCourse.setAdapter(AdapterCourse);
        spDesert.setAdapter(AdapterDessert);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course = spCourse.getSelectedItem().toString();
                String dessert = spDesert.getSelectedItem().toString();
                TextView lblOutput = (TextView) findViewById(R.id.lblOutput);
                lblOutput.setText("主餐 : " + course + "\n甜點 : " + dessert);
            }
        });
    }
}