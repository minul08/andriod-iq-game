package com.example.minul.iqgame;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    public Game_Data gameData = new Game_Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        newGameButton();
        continueButton();
        Context context = this;
        abtButton(context);
        exitButton();
    }


    public void newGameButton() {
        Button newGame = (Button) findViewById(R.id.newGame);
        newGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameData.setCont(false);
                startActivity(new Intent(getApplicationContext(), Difficulty.class));
            }
        });
    }

    public void continueButton() {
        Button cont = (Button) findViewById(R.id.cont);
        cont.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameData.setCont(true);
                startActivity(new Intent(getApplicationContext(), GamePlay.class));
            }
        });
    }

    public void abtButton(final Context context) {
                        Button abt = (Button) findViewById(R.id.abt);
                abt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                        builder1.setMessage("Answer the question as fast as possible. \n\nThe longer you take to answer the Question" +
                                " the points accumulated would be lower" +
                                "\n\nIf you chose the hint mode 4 attempts per question will be allowed. \nThe application will also let you know" +
                                " if the correct answer is greater than or less than the answer you entered");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
    }

    public void exitButton(){
        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
