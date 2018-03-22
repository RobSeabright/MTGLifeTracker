package com.example.rob.mtglifetracker;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        ImageView diceRoll = findViewById(R.id.diceRoll);

        String str = "dice" + rnd.nextInt(5);
        diceRoll.setImageDrawable(getResources().getDrawable(getResourceID(str, getApplicationContext())));
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
