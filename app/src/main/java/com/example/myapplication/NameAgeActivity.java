package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameAgeActivity extends StateHelper {
    private Bundle state = new Bundle();

    EditText etName;
    EditText etAge;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_age);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);

        restoreState(
                SAVE_NAME_AGE,
                new State(etName, NAME),
                new State(etAge, AGE)
        );
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        switch (view.getId()) {
            case R.id.btnSave:
                state.putString(NAME, etName.getText().toString());
                state.putString(AGE, etAge.getText().toString());

                saveState(intent, SAVE_NAME_AGE, true, state);
                break;
            case R.id.btnCancel:
                saveState(intent, SAVE_NAME_AGE, false);
                break;
        }
        startActivity(intent);
    }
}
