package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find 4 buttons and set on Click lister
        findViewById(R.id.btnNameAge).setOnClickListener(this);
        findViewById(R.id.btnCheckboxDate).setOnClickListener(this);
        findViewById(R.id.btnRadioTimePicker).setOnClickListener(this);
        findViewById(R.id.btnRatingBarTimePicker).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent("main");
        switch (view.getId()) {
            case R.id.btnNameAge:
                Log.i("Main", "name age");
                intent.setAction("na");
                break;

            case R.id.btnCheckboxDate:
                Log.i("Main", "checkbox");
                intent.setAction("cd");
                break;

            case R.id.btnRadioTimePicker:
                Log.i("Main", "radio");
                intent.setAction("rt");
                break;

            case R.id.btnRatingBarTimePicker:
                Log.i("Main", "rating");
                intent.setAction("rbt");
                break;
            default:
                Log.e("Main", "No activity found");
        }

        startActivity(intent);
    }
}
