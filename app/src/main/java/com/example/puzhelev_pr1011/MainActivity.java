package com.example.puzhelev_pr1011;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private EditText editTextDate;
    private Button buttonDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_main);

        this.editTextDate = (EditText) this.findViewById(R.id.editTextDate);
        this.buttonDate = (Button) this.findViewById(R.id.buttonContinue);
        this.datePicker = (DatePicker) this.findViewById(R.id.datePicker);

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        this.datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                datePickerChange(datePicker, year, month, dayOfMonth);
            }
        });
        this.buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
            }
        });

    }

    private void showDate() {
        int year = this.datePicker.getYear();
        int month = this.datePicker.getMonth();
        int day = this.datePicker.getDayOfMonth();

        Toast.makeText(this,  "Date" + day +"-" + (month +1) +"-" + year, Toast.LENGTH_LONG).show();
    }

    private void datePickerChange(DatePicker view, int year, int month, int dayOfMonth) {
        Log.d("Date", "Years=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
        this.editTextDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
    };
}