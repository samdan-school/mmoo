package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

abstract class StateHelper extends AppCompatActivity implements View.OnClickListener {
    static public final String SAVE_NAME_AGE = "SAVE_NAME_AGE";
    static public final String SAVE_CHECKBOX_DATE = "SAVE_CHECKBOX_DATE";
    static public final String SAVE_RADIO_TIME = "SAVE_RADIO_TIME";
    static public final String SAVE_RATING_TIME = "SAVE_RATING_TIME";
    static public final String NAME = "NAME";
    static public final String AGE = "AGE";
    static public final String CB1 = "CB1";
    static public final String CB2 = "CB2";
    static public final String CB3 = "CB3";
    static public final String YEAR = "YEAR";
    static public final String MONTH = "MONTH";
    static public final String DAY = "DAY";
    static public final String MALE = "MALE";
    static public final String FEMALE = "FEMALE";
    static public final String HOUR = "HOUR";
    static public final String MINUTE = "MINUTE";
    static public final String RATING = "RATING";

    public void saveState(Intent intent, String stateName, boolean bSave, Bundle... state) {
        Bundle bundle = getIntent().getExtras();
        for (String name : new String[] {
                SAVE_NAME_AGE,
                SAVE_CHECKBOX_DATE,
                SAVE_RADIO_TIME,
                SAVE_RATING_TIME
        }) {
            if (!name.equals(stateName) && bundle != null)
                intent.putExtra(name, bundle.getBundle(name));
        }
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
                } else if (state.view instanceof RadioButton && state.view2 instanceof RadioButton) {
                    boolean m = stateBundle.getBoolean(MALE);
                    boolean f = stateBundle.getBoolean(FEMALE);
                    RadioButton rbm = (RadioButton) state.view;
                    RadioButton rbf = (RadioButton) state.view2;
                    rbm.setChecked(m);
                    rbf.setChecked(f);
                } else if (state.view instanceof DatePicker) {
                    ((DatePicker) state.view).updateDate(
                            stateBundle.getInt(YEAR),
                            stateBundle.getInt(MONTH),
                            stateBundle.getInt(DAY)
                    );
                } else if (state.view instanceof TimePicker) {
                    ((TimePicker) state.view).setHour(stateBundle.getInt(HOUR));
                    ((TimePicker) state.view).setMinute(stateBundle.getInt(MINUTE));
                } else if (state.view instanceof RatingBar) {
                    ((RatingBar) state.view).setRating(stateBundle.getInt(RATING));
                }
            }
        }
    }

    class State {
        View view;
        View view2;
        String key;

        State(View view, String key) {
            this.view = view;
            this.key = key;
        }

        State(View view) {
            this.view = view;
        }

        State(View view, View view2) {
            this.view = view;
            this.view2 = view2;
        }
    }
}
