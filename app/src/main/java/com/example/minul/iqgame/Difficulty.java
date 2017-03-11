package com.example.minul.iqgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;

/**
 * Created by Minul on 3/1/2016.
 */
public class Difficulty extends Activity {

    public Game_Data gameData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty_level);
        start_game();
        switchControl();
    }

    public void start_game() {

        Button start_game = (Button) findViewById(R.id.start_game);
        final RadioButton dif_novice = (RadioButton) findViewById(R.id.novice);
        final RadioButton dif_easy = (RadioButton) findViewById(R.id.easy);
        final RadioButton dif_medium = (RadioButton) findViewById(R.id.medium);
        final RadioButton dif_guru = (RadioButton) findViewById(R.id.guru);

        start_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameData = new Game_Data();
                if (dif_novice.isChecked()) {
                    gameData.setDifficulty_level("novice");
                }
                if (dif_easy.isChecked()) {
                    gameData.setDifficulty_level("easy");
                }
                if (dif_medium.isChecked()) {
                    gameData.setDifficulty_level("medium");
                }
                if (dif_guru.isChecked()) {
                    gameData.setDifficulty_level("guru");
                }
                startActivity(new Intent(getApplicationContext(), GamePlay.class));
            }
        });
    }

    public void switchControl() {
        gameData.setNumOfHints(4);
        Switch mySwitch = (Switch) findViewById(R.id.hint);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    gameData.setHintMode(true);
                } else {
                    gameData.setHintMode(false);
                }

            }
        });

    }
}

