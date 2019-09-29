package com.example.myapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import static android.content.Intent.ACTION_DIAL;

public class MainActivity extends StateHelper implements View.OnClickListener {
    private Bundle bundleNameAge;
    private Bundle bundleCheckboxDate;
    private Bundle bundleRadioTime;
    private Bundle bundleRatingTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find 4 buttons and set on Click lister
        findViewById(R.id.btnNameAge).setOnClickListener(this);
        findViewById(R.id.btnCheckboxDate).setOnClickListener(this);
        findViewById(R.id.btnRadioTimePicker).setOnClickListener(this);
        findViewById(R.id.btnRatingBarTimePicker).setOnClickListener(this);
        findViewById(R.id.btnCall).setOnClickListener(this);
        findViewById(R.id.btnAlarm).setOnClickListener(this);
        findViewById(R.id.btnWebSearch).setOnClickListener(this);

        registerForContextMenu(findViewById(R.id.menu));

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            bundleNameAge = bundle.getBundle(SAVE_NAME_AGE);
            bundleCheckboxDate = bundle.getBundle(SAVE_CHECKBOX_DATE);
            bundleRadioTime = bundle.getBundle(SAVE_RADIO_TIME);
            bundleRatingTime = bundle.getBundle(SAVE_RATING_TIME);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btnNameAge:
                Log.i("Main", "name age");
                intent.setClass(this, NameAgeActivity.class);
                break;

            case R.id.btnCheckboxDate:
                Log.i("Main", "checkbox");
                intent.setClass(this, CheckboxDateActivity.class);
                break;

            case R.id.btnRadioTimePicker:
                Log.i("Main", "radio");
                intent.setClass(this, RadioTimeActivity.class);
                break;

            case R.id.btnRatingBarTimePicker:
                Log.i("Main", "rating");
                intent.setClass(this, RatingBarTimeActivity.class);
                break;

            case R.id.btnCall:
                Log.i("Main", "call");
                intent.setAction(ACTION_DIAL);
                break;

            case R.id.btnAlarm:
                Log.i("Main", "ACTION_SHOW_ALARMS");
                intent.setAction(AlarmClock.ACTION_SHOW_ALARMS);
                break;

            case R.id.btnWebSearch:
                Log.i("Main", "ACTION_WEB_SEARCH");
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "https://sisi.num.edu.mn");
                break;

            default:
                Log.e("Main", "No activity found");
        }

        intent.putExtra(SAVE_NAME_AGE, bundleNameAge);
        intent.putExtra(SAVE_CHECKBOX_DATE, bundleCheckboxDate);
        intent.putExtra(SAVE_RADIO_TIME, bundleRadioTime);
        intent.putExtra(SAVE_RATING_TIME, bundleRatingTime);
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.link_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()) {
            case R.id.mNameAge:
                Log.i("Main", "Menu name age");
                intent.setAction("na");
                break;

            case R.id.mCheckboxDate:
                Log.i("Main", "Menu checkbox");
                intent.setAction("cd");
                break;

            case R.id.mRadioTimePicker:
                Log.i("Main", "Menu radio");
                intent.setAction("rt");
                break;

            case R.id.mRatingBarTimePicker:
                Log.i("Main", "Menu rating");
                intent.setAction("rbt");
                break;
            default:
                Log.e("Main", "Menu No activity found");
                return super.onContextItemSelected(item);
        }

        intent.putExtra(SAVE_NAME_AGE, bundleNameAge);
        intent.putExtra(SAVE_CHECKBOX_DATE, bundleCheckboxDate);
        intent.putExtra(SAVE_RADIO_TIME, bundleRadioTime);
        intent.putExtra(SAVE_RATING_TIME, bundleRatingTime);
        startActivity(intent);
        return true;
    }
}
