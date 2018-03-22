package com.example.rob.mtglifetracker;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by rob on 22/03/18.
 */

public class RollDice extends AppCompatActivity {

    final Random rnd = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rolldice);

        final ImageView diceRoll = findViewById(R.id.diceRoll);
        Button reroll = findViewById(R.id.rerollButton);

        String dice = "dice" + rnd.nextInt(5);
        diceRoll.setImageDrawable(getResources().getDrawable(getResourceID(dice, getApplicationContext())));

        reroll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String reDice = "dice" + rnd.nextInt(5);
                diceRoll.setImageDrawable(getResources().getDrawable(getResourceID(reDice, getApplicationContext())));
            }
        });
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
