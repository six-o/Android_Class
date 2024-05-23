package com.example.datetimepickerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener {
    private TextView lblOutput;
    private Calendar dt = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblOutput = (TextView) findViewById(R.id.lblOutput);

        Button btnDay = (Button) findViewById(R.id.btnDay);
        Button btnTime = (Button) findViewById(R.id.btnTime);

        btnDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = new DatePickerDialog(MainActivity.this,
                        MainActivity.this,
                        dt.get(Calendar.YEAR),
                        dt.get(Calendar.MONTH),
                        dt.get(Calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 TimePickerDialog tpd = new TimePickerDialog(MainActivity.this,
                         new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
                            lblOutput.setText("時間 : " + hourOfDay + ":" + minute);
                        }
                 },
                         dt.get(Calendar.HOUR_OF_DAY),
                         dt.get(Calendar.MINUTE), false);
                 tpd.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        lblOutput.setText("日期 : " + year + "/" + (month + 1) + "/" + dayOfMonth);
    }
}