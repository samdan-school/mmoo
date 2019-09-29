package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class CheckboxDateActivity extends StateHelper implements View.OnClickListener {
    private Bundle state = new Bundle();
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_date);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);

        restoreState(
                SAVE_CHECKBOX_DATE,
                new State(cb1, CB1),
                new State(cb2, CB2),
                new State(cb3, CB3)
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

                saveState(intent, SAVE_CHECKBOX_DATE, true, state);
                break;
            case R.id.btnCancel:
                saveState(intent, SAVE_CHECKBOX_DATE, false);
                break;
        }
        startActivity(intent);
    }
}
