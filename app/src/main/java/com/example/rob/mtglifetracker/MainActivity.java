package com.example.rob.mtglifetracker;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout player1Layout;
    private Layout player2Layout;
    private TextView player1LifeView;
    private TextView player2LifeView;
    private int player1Life = 20;
    private int player2Life = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1Layout = findViewById(R.id.player1Layout);
        player1LifeView = findViewById(R.id.player1Life);
        player2LifeView = findViewById(R.id.player2Life);
        ImageButton player1Plus = findViewById(R.id.player1Plus);
        ImageButton player1Minus = findViewById(R.id.player1Minus);
        ImageButton player2Plus = findViewById(R.id.player2Plus);
        ImageButton player2Minus = findViewById(R.id.player2Minus);
        ImageButton resetLife = findViewById(R.id.resetButton);
        ImageButton rollDice = findViewById(R.id.diceButton);
        ImageButton settings = findViewById(R.id.settingsButton);

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

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(),AppSettings.class),13);
            }
        });
    }

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Resources res = getResources();

        if (requestCode == 13 && resultCode == RESULT_OK) {

            String image = data.getStringExtra("background");

//            Drawable drawable = res.getDrawable(R.drawable.image);
            player1Layout.setBackground(getResources().getDrawable(getResourceID(image, getApplicationContext())));
        }
    }

    protected static int getResourceID(final String resName, final Context ctx) {
        final int ResourceID = ctx.getResources().getIdentifier(resName, "drawable",
                ctx.getApplicationInfo().packageName);
        if (ResourceID == 0) {
            throw new IllegalArgumentException ("No resource string found with name " + resName);
        } else {
            return ResourceID;
        }
    }
}
