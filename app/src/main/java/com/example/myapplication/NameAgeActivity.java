package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameAgeActivity extends StateHelper {
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
                new State(etName, NAME),
                new State(etAge, AGE)
        );
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        switch (view.getId()) {
            case R.id.btnSave:
                saveState(intent, true,
                        new State<>(NAME, etName.getText().toString()),
                        new State<>(AGE, etAge.getText().toString()));
                break;
            case R.id.btnCancel:
                saveState(intent, false);
                break;
        }
        startActivity(intent);
    }
}
