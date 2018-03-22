package com.example.rob.mtglifetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView player1LifeView;
    private TextView player2LifeView;
    private int player1Life = 20;
    private int player2Life = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1LifeView = findViewById(R.id.player1Life);
        player2LifeView = findViewById(R.id.player2Life);
        ImageButton player1Plus = findViewById(R.id.player1Plus);
        ImageButton player1Minus = findViewById(R.id.player1Minus);
        ImageButton player2Plus = findViewById(R.id.player2Plus);
        ImageButton player2Minus = findViewById(R.id.player2Minus);
        ImageButton resetLife = findViewById(R.id.resetButton);
        ImageButton rollDice = findViewById(R.id.diceButton);

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

        resetLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1Life = 20;
                player2Life = 20;
                player1LifeView.setText(String.valueOf(player1Life));
                player2LifeView.setText(String.valueOf(player2Life));
            }
        });

        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RollDice.class));
            }
        });
    }
}
