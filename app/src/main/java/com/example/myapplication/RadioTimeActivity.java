package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TimePicker;

public class RadioTimeActivity extends StateHelper implements View.OnClickListener {
    private Bundle state = new Bundle();

    private RadioButton rbMale;
    private RadioButton rbFemale;
    private TimePicker tp;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_timepicker);

        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        tp = findViewById(R.id.tp);

        tp.setIs24HourView(true);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);

        restoreState(
                SAVE_RADIO_TIME,
                new State(rbMale, rbFemale),
                new State(tp)
        );
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        switch (view.getId()) {
            case R.id.btnSave:
                state.putBoolean(MALE, rbMale.isChecked());
                state.putBoolean(FEMALE, rbFemale.isChecked());
                state.putInt(HOUR, tp.getHour());
                state.putInt(MINUTE, tp.getMinute());

                saveState(intent, SAVE_RADIO_TIME, true, state);
                break;
            case R.id.btnCancel:
                saveState(intent, SAVE_RADIO_TIME, false);
                break;
        }
        startActivity(intent);
    }
}
