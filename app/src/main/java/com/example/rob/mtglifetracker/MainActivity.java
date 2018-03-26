package com.example.rob.mtglifetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Used for setting player backgrounds
    private LinearLayout player1Layout;
    private LinearLayout player2Layout;
    private int player1Image = 3;
    private int player2Image = 1;

    //Used for setting player life totals
    private TextView player1LifeView;
    private TextView player2LifeView;
    private int player1Life = 20;
    private int player2Life = 20;


    /**
     * Creates a life tracker for Magic The Gathering
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Gets and assigns GUI objects
        setContentView(R.layout.activity_main);
        player1Layout = findViewById(R.id.player1Layout);
        player2Layout = findViewById(R.id.player2Layout);
        player1LifeView = findViewById(R.id.player1Life);
        player2LifeView = findViewById(R.id.player2Life);
        ImageButton player1Plus = findViewById(R.id.player1Plus);
        ImageButton player1Minus = findViewById(R.id.player1Minus);
        ImageButton player2Plus = findViewById(R.id.player2Plus);
        ImageButton player2Minus = findViewById(R.id.player2Minus);
        ImageButton resetLife = findViewById(R.id.resetButton);
        ImageButton rollDice = findViewById(R.id.diceButton);
        ImageButton settings = findViewById(R.id.settingsButton);

        /**
         * Used to set play life totals on button clicks
         */
        player1Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1Life--;
                player1LifeView.setText(String.valueOf(player1Life));
            }
        });

        player1Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1Life++;
                player1LifeView.setText(String.valueOf(player1Life));
            }
        });

        player2Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2Life++;
                player2LifeView.setText(String.valueOf(player2Life));
            }
        });

        player2Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2Life--;
                player2LifeView.setText(String.valueOf(player2Life));
            }
        });

        /**
         * Resets each player's life back to the staring total of 20
         */
        resetLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1Life = 20;
                player2Life = 20;
                player1LifeView.setText(String.valueOf(player1Life));
                player2LifeView.setText(String.valueOf(player2Life));

            }
        });

        /**
         * Pops up a dice roller and rolls a dice.
         */
        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RollDice.class));
            }
        });

        /**
         * Pops up app settings view so player's can change their background
         */
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), AppSettings.class), 13);
            }
        });
    }

    /**
     * Assigns data sent back from settings view and calls the setBackgound function to change
     * player's backgrounds
     * @param requestCode
     * @param resultCode
     * @param data
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 13 && resultCode == RESULT_OK) {

            player1Image = data.getIntExtra("player1Background", 3);
            player2Image = data.getIntExtra("player2Background", 1);
            setBackground();
        }
    }

    /**
     * Sets each player's background image based on the selection in the setting's view
     */
    private void setBackground() {
        switch (player1Image) {
            case (0):
                player1Layout.setBackgroundResource(R.drawable.black_mana);
                break;
            case (1):
                player1Layout.setBackgroundResource(R.drawable.blue_mana);
                break;
            case (2):
                player1Layout.setBackgroundResource(R.drawable.green_mana);
                break;
            case (3):
                player1Layout.setBackgroundResource(R.drawable.red_mana);
                break;
            case (4):
                player1Layout.setBackgroundResource(R.drawable.white_mana);
        }
        switch (player2Image) {
            case (0):
                player2Layout.setBackgroundResource(R.drawable.black_mana);
                break;
            case (1):
                player2Layout.setBackgroundResource(R.drawable.blue_mana);
                break;
            case (2):
                player2Layout.setBackgroundResource(R.drawable.green_mana);
                break;
            case (3):
                player2Layout.setBackgroundResource(R.drawable.red_mana);
                break;
            case (4):
                player2Layout.setBackgroundResource(R.drawable.white_mana);
        }
    }

    /**
     * Saves an instance state containing player's life totals and chosen backgrounds
     * @param savedInstanceState
     */
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("player1Life", player1Life);
        savedInstanceState.putInt("player2Life", player2Life);
        savedInstanceState.putInt("player1Image", player1Image);
        savedInstanceState.putInt("player2Image", player2Image);

    }

    /**
     * Restores an instance state containing player's life totals and chosen backgrounds
     * @param savedInstanceState
     */
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        player1Life = savedInstanceState.getInt("player1Life");
        player2Life = savedInstanceState.getInt("player2Life");
        player1Image = savedInstanceState.getInt("player1Image");
        player2Image = savedInstanceState.getInt("player2Image");
        setBackground();
    }
}
