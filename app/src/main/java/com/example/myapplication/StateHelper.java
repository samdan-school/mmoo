package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

abstract class StateHelper extends AppCompatActivity implements View.OnClickListener {
    static public final String SAVE_NAME_AGE = "SAVE_NAME_AGE";
    static public final String SAVE_CHECKBOX_DATE = "SAVE_CHECKBOX_DATE";
    static public final String NAME = "NAME";
    static public final String AGE = "AGE";
    static public final String CB1 = "CB1";
    static public final String CB2 = "CB2";
    static public final String CB3 = "CB3";

    public void saveState(Intent intent, String stateName , boolean bSave,Bundle... state) {
        if (bSave) {
            intent.putExtra(stateName, state[0]);
        }
    }

    public void restoreState(String stateName, State... states) {
        Bundle bundle = getIntent().getExtras();
        Bundle stateBundle = null;
        if (bundle != null) {
            stateBundle = bundle.getBundle(stateName);
        }
        if (stateBundle != null) {
            for (State state : states) {
                if (state.view instanceof EditText) {
                    ((EditText) state.view).setText(stateBundle.getString(state.key));
                } else if (state.view instanceof CheckBox) {
                    ((CheckBox) state.view).setChecked(stateBundle.getBoolean(state.key));
                }
            }
        }
    }

    class State {
        View view;
        String key;

        State(View view, String key) {
            this.view = view;
            this.key = key;
        }
    }
}
