package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class CheckboxDateActivity extends StateHelper implements View.OnClickListener {
    private Bundle state = new Bundle();
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private DatePicker dp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_date);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        dp = findViewById(R.id.dp);

        dp.setSpinnersShown(true);
        dp.setCalendarViewShown(false);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        dp.init(year, month, day, null);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);

        restoreState(
                SAVE_CHECKBOX_DATE,
                new State(cb1, CB1),
                new State(cb2, CB2),
                new State(cb3, CB3),
                new State(dp)
        );
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        switch (view.getId()) {
            case R.id.btnSave:
                state.putBoolean(CB1, cb1.isChecked());
                state.putBoolean(CB2, cb2.isChecked());
                state.putBoolean(CB3, cb3.isChecked());
                state.putInt(YEAR, dp.getYear());
                state.putInt(MONTH, dp.getMonth());
                state.putInt(DAY, dp.getDayOfMonth());

                saveState(intent, SAVE_CHECKBOX_DATE, true, state);
                break;
            case R.id.btnCancel:
                saveState(intent, SAVE_CHECKBOX_DATE, false);
                break;
        }
        startActivity(intent);
    }
}
