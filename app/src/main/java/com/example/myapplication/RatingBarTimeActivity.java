package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class RatingBarTimeActivity extends StateHelper implements View.OnClickListener {
    private Bundle state = new Bundle();

    private RatingBar rb;
    private TimePicker tp;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratingbar_timepicker);

        rb = findViewById(R.id.ratingBar);

        tp = findViewById(R.id.tp);
        tp.setIs24HourView(true);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);

        restoreState(
                SAVE_RATING_TIME,
                new State(rb),
                new State(tp)
        );
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        switch (view.getId()) {
            case R.id.btnSave:
                state.putInt(RATING, (int)rb.getRating());
                state.putInt(HOUR, tp.getHour());
                state.putInt(MINUTE, tp.getMinute());

                saveState(intent, SAVE_RATING_TIME, true, state);
                break;
            case R.id.btnCancel:
                saveState(intent, SAVE_RATING_TIME, false);
                break;
        }
        startActivity(intent);
    }
}
