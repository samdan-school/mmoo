package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NameAgeActivity extends AppCompatActivity implements View.OnClickListener {
    // saved instance state key name
    private final String SAVE = "save";
    private final String NAME = "name";
    private final String AGE = "age";

    private boolean bSave;
    EditText etName;
    EditText etAge;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_age);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(SAVE)) {
                etName.setText(savedInstanceState.getString(NAME));
                etAge.setText(savedInstanceState.getString(AGE));
            }
            Log.i("Name", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }
        Log.i("Name", "djaskdhkashdkhaskdhkjashdjkjhaskjdhjkashjdkh");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                bSave = true;
                Log.i("Name Age", "Save");
                break;
            case R.id.btnCancel:
                bSave = false;
                Log.i("Name Age", "Cancel");
                break;
        }

        this.onPause();
        startActivity(new Intent(getBaseContext(), MainActivity.class));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(SAVE, bSave);
        savedInstanceState.putString(NAME, etName.getText().toString());
        savedInstanceState.putString(AGE, etAge.getText().toString());

        Log.i("name", savedInstanceState.getString(NAME));
        super.onSaveInstanceState(savedInstanceState);
        Log.i("Name", "save Instance state");
    }
}
