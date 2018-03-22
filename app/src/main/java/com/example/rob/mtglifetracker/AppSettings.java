package com.example.rob.mtglifetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

/**
 * Created by rob on 22/03/18.
 */

public class AppSettings extends Activity {

    private RadioGroup background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appsettings);
        background = findViewById(R.id.backgrounds);

    }

    public void onBackPressed() {
        Intent i = new Intent();
        String selected = "blue_mana";
        int radioId = background.getCheckedRadioButtonId();
        View radioButton = background.findViewById(radioId);
        int index = background.indexOfChild(radioButton);

        switch (index) {
            case (0): selected = "black_mana";
                break;
            case (1): selected = "blue_mana";
                break;
            case (2): selected = "green_mana";
                break;
            case (3): selected = "red_mana";
                break;
            case (4): selected = "white_mana";
                break;
        }

        i.putExtra("background", selected);
        setResult(RESULT_OK, i);
        finish();
    }
}
