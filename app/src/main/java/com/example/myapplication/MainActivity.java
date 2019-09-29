package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends StateHelper implements View.OnClickListener {
    private Bundle bundleNameAge;
    private Bundle bundleCheckboxDate;
    private Bundle bundleRadioTime;
    private Bundle bundleRatingTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find 4 buttons and set on Click lister
        findViewById(R.id.btnNameAge).setOnClickListener(this);
        findViewById(R.id.btnCheckboxDate).setOnClickListener(this);
        findViewById(R.id.btnRadioTimePicker).setOnClickListener(this);
        findViewById(R.id.btnRatingBarTimePicker).setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            bundleNameAge = bundle.getBundle(SAVE_NAME_AGE);
            bundleCheckboxDate = bundle.getBundle(SAVE_CHECKBOX_DATE);
            bundleRadioTime = bundle.getBundle(SAVE_RADIO_TIME);
            bundleRatingTime = bundle.getBundle(SAVE_RATING_TIME);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btnNameAge:
                Log.i("Main", "name age");
                intent.setAction("na");
                intent.putExtra(SAVE_NAME_AGE, bundleNameAge);
                break;

            case R.id.btnCheckboxDate:
                Log.i("Main", "checkbox");
                intent.setAction("cd");
                intent.putExtra(SAVE_CHECKBOX_DATE, bundleCheckboxDate);
                break;

            case R.id.btnRadioTimePicker:
                Log.i("Main", "radio");
                intent.setAction("rt");
                intent.putExtra(SAVE_RADIO_TIME, bundleRadioTime);
                break;

            case R.id.btnRatingBarTimePicker:
                Log.i("Main", "rating");
                intent.setAction("rbt");
                intent.putExtra(SAVE_RATING_TIME, bundleRatingTime);
                break;
            default:
                Log.e("Main", "No activity found");
        }

        startActivity(intent);
    }
}
