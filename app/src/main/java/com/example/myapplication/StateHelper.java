package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

abstract class StateHelper extends AppCompatActivity implements View.OnClickListener {
    static public final String NAME = "NAME";
    static public final String AGE = "AGE";

    public void saveState(Intent intent, boolean bSave, State... states) {
        if (bSave) {
            for (State state : states) {
                if (state.value instanceof String)
                    intent.putExtra(state.name, (String) state.value);
            }
        }
    }

    public void restoreState(State... states) {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            for (State state : states) {
                if (state.view instanceof EditText) {
                    ((EditText) state.view).setText(bundle.getString(state.key));
                }
            }
        }
    }

    class State<T> {
        String name;
        View view;
        T value;
        String key;

        State(String name, T value) {
            this.name = name;
            this.value = value;
        }

        State(View view, String key) {
            this.view = view;
            this.key = key;
        }
    }
}
