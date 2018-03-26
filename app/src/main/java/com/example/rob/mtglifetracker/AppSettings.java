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

    private RadioGroup player1Background;
    private RadioGroup player2Background;

    /**
     * Creates the settings view
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appsettings);
        player1Background = findViewById(R.id.player1Backgrounds);
        player2Background = findViewById(R.id.player2Backgrounds);
    }

    /**
     * Sends the user back to the main activity storing the selection of background images
     */
    public void onBackPressed() {
        Intent i = new Intent();
        int p1RadioId = player1Background.getCheckedRadioButtonId();
        View p1RadioButton = player1Background.findViewById(p1RadioId);
        int p1Index = player1Background.indexOfChild(p1RadioButton);

        int p2RadioId = player2Background.getCheckedRadioButtonId();
        View p2RadioButton = player2Background.findViewById(p2RadioId);
        int p2Index = player2Background.indexOfChild(p2RadioButton);

        i.putExtra("player1Background", p1Index);
        i.putExtra("player2Background", p2Index);
        setResult(RESULT_OK, i);
        finish();
    }
}
