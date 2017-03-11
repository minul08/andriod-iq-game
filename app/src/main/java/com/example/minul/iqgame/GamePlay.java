package com.example.minul.iqgame;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Minul on 2/27/2016.
 */
public class GamePlay extends AppCompatActivity {
    TextView sec;
    TextView qa;
    TextView text;
    TextView timeElapsedView;
    int answer = 0;
    boolean dialogBox = false;
    public int amount = 11;
    Game_Data gameData;
    String question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);
        gameData.setNumOfHints(4);
        gameData.setId(1);
        gameData.setNumberOfQuestions(1);
        sec = (TextView) findViewById(R.id.timeRemaining);
        if (gameData.isCont()) {
            System.out.println("Game Continuing");
            Save_Retrieve_Game_Data savedGame = new Save_Retrieve_Game_Data(getApplicationContext());
            savedGame.retGameData(1);
        }

        qa = (TextView) findViewById(R.id.QA);
        QATextArea();
        button0();
        button1();
        button2();
        button3();
        button4();
        button5();
        button6();
        button7();
        button8();
        button9();
        buttonHash();
        buttonMinus();
        difLevelChecker();
        hintMode();
        //delButton();
        //questionGenNovice();
    }

    public void delButton(){
//qa = (TextView)findViewById(R.id.QA);
        String text = qa.getText().toString();
        String delText = "";
        for(int i=0; i<text.length()-1; i++){
            delText = delText+text.charAt(i);
        }

        qa.setText(delText);
    }

    public void QATextArea() {
        qa.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    public void button1() {
        Button b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qa.setText(qa.getText() + "1");
            }
        });

    }


    public void button2() {
        Button b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qa.setText(qa.getText() + "2");
            }
        });
    }


    public void button3() {
        Button b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qa.setText(qa.getText() + "3");
            }
        });
    }


    public void button4() {
        Button b4 = (Button) findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qa.setText(qa.getText() + "4");
            }
        });
    }


    public void button5() {
        Button b5 = (Button) findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qa.setText(qa.getText() + "5");
            }
        });
    }


    public void button6() {
        Button b6 = (Button) findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qa.setText(qa.getText() + "6");
            }
        });
    }


    public void button7() {
        Button b7 = (Button) findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qa.setText(qa.getText() + "7");
            }
        });
    }


    public void button8() {
        Button b8 = (Button) findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qa.setText(qa.getText() + "8");
            }
        });
    }


    public void button9() {
        Button b9 = (Button) findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qa.setText(qa.getText() + "9");
            }
        });
    }


    public void button0() {
        Button b0 = (Button) findViewById(R.id.b0);
        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qa.setText(qa.getText() + "0");
            }
        });
    }


    public void buttonHash() {
        Button hash = (Button) findViewById(R.id.bhash);
        hash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //qa.setText(qa.getText() + "#");
                answerGuiRespond();
                //dialogShow();
                //pointCalc();

            }
        });
    }


    public void buttonMinus() {
        Button bminus = (Button) findViewById(R.id.bminus);
        bminus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qa.setText(qa.getText() + "-");
            }
        });
    }

    public CountDownTimer time;

    public void timer() {
        text = (TextView) this.findViewById(R.id.sec);
        timeElapsedView = (TextView) this.findViewById(R.id.timeRemaining);

        time = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText("" + millisUntilFinished / 1000);

            }

            public void onFinish() {
                if (gameData.getNumberOfQuestions() > amount) {
                    time.cancel();
                    scoreDialogBox();
                } else {
                    difLevelChecker();
                }
            }

        }.start();
    }

    public void scoreDialogBox() {

        Context context = this;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage("Your Score is " + gameData.getScore() + "\n" + "Do you want to play again?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //dialogBox = false;
                        dialog.cancel();
                        startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // dialogBox = false;
                        dialog.cancel();
                        startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    }
                });
        time.cancel();
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public int numberGen() {
        Random rand = new Random();
        int randomNum = rand.nextInt((9 - 1) + 1) + 1;
        return randomNum;
    }

    public String signGen() {
        Random rand = new Random();
        int operator = rand.nextInt((4 - 1) + 1) + 1;
        String sign = null;
        switch (operator) {

            case 1:
                sign = "+";
                break;
            case 2:
                sign = "-";
                break;
            case 3:
                sign = "*";
                break;
            case 4:
                sign = "/";
                break;
        }
        return sign;
    }

    public void questionGenNovice() {
        question = null;
        question = Integer.toString(numberGen());
        question = question + genSignNum();
        question = question + "=";
        qa.setText(question);
        System.out.println("Question: " + gameData.getNumberOfQuestions());
        answerCheck(question);
        timer();
        gameData.setNumberOfQuestions(gameData.getNumberOfQuestions() + 1);
    }

    public void questionGenEasy() {
        question = null;
        question = Integer.toString(numberGen());
        question = question + genSignNum();
        question = question + genSignNum();
        question = question + "=";
        qa.setText(question);
        System.out.println("Question: " + gameData.getNumberOfQuestions());
        answerCheck(question);
        timer();
        gameData.setNumberOfQuestions(gameData.getNumberOfQuestions() + 1);
    }

    public void questionGenMedium() {
        question = null;
        question = Integer.toString(numberGen());

        for (int i = 0; i < 3; i++) {
            question = question + genSignNum();
        }

        question = question + "=";
        qa.setText(question);
        System.out.println("Question: " + gameData.getNumberOfQuestions());
        answerCheck(question);
        timer();
        gameData.setNumberOfQuestions(gameData.getNumberOfQuestions() + 1);
    }

    public void questionGenGuru() {
        question = null;
        question = Integer.toString(numberGen());

        for (int i = 0; i < 4; i++) {
            question = question + genSignNum();
        }

        question = question + "=";
        qa.setText(question);
        answerCheck(question);
        System.out.println("Question: " + gameData.getNumberOfQuestions());
        timer();
        gameData.setNumberOfQuestions(gameData.getNumberOfQuestions() + 1);
    }

    public String genSignNum() {
        String set = null;
        set = signGen();
        set = set + Integer.toString(numberGen());
        return set;
    }

    public void difLevelChecker() {
        gameData.numOfHints = 4;
        hintMode();
        Game_Data gameData = new Game_Data();
        if (gameData.getDifficulty_level().equalsIgnoreCase("easy")) {
            questionGenEasy();
        }

        if (gameData.getDifficulty_level().equalsIgnoreCase("novice")) {
            questionGenNovice();
        }

        if (gameData.getDifficulty_level().equalsIgnoreCase("medium")) {
            questionGenMedium();
        }

        if (gameData.getDifficulty_level().equalsIgnoreCase("guru")) {
            questionGenGuru();
        }
    }

    public Spannable WordtoSpan;
    public TextView responce;
    public void answerGuiRespond() {
        responce = (TextView) findViewById(R.id.responce);
        String[] text = qa.getText().toString().split("=");
        System.out.println("Split: " + text[0]);

        if(text.length>1) {
            if ((Integer.valueOf(text[1]) == answer)) {
                WordtoSpan = new SpannableString("CORRECT");
                WordtoSpan.setSpan(new ForegroundColorSpan(Color.GREEN), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                responce.setText(WordtoSpan);

                Delay();
                time.cancel();
                pointCalc();

                if (gameData.isHintMode()) {
                    if (gameData.numberOfQuestions < amount) {
                        gameData.numOfHints = 4;
                        hintMode();
                        difLevelChecker();
                    } else {
                        time.cancel();
                        scoreDialogBox();
                    }
                } else {
                    if (gameData.numberOfQuestions < amount) {
                        difLevelChecker();
                    } else {
                        time.cancel();
                        scoreDialogBox();
                    }
                }

            } else {
                wrongProceed(Integer.valueOf(text[1]));
            }
        }else{
            wrongProceed(Integer.valueOf(text[1]));
        }
    }
public void compare(int ans){
    if(ans>answer){
        sec.setText("Less");
        Delay();
    }else{
        sec.setText("Greater");
        Delay();
    }
}
    public void wrongProceed(int ans){
        WordtoSpan = new SpannableString("WRONG");
        WordtoSpan.setSpan(new ForegroundColorSpan(Color.RED), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        responce.setText(WordtoSpan);

        Delay();

        if (gameData.isHintMode()) {

            if (gameData.numberOfQuestions < amount) {
                if((gameData.numOfHints<=4)&&(gameData.numOfHints>1)){
                    gameData.numOfHints--;
                    compare(ans);
                    hintMode();
                }else{
                    time.cancel();
                    gameData.numOfHints = 4;
                    hintMode();
                    difLevelChecker();
                }

            } else {
                scoreDialogBox();
            }

        } else {

            if (gameData.numberOfQuestions < amount) {
                time.cancel();
                difLevelChecker();
            } else {
                time.cancel();
                scoreDialogBox();

            }
        }
    }
    public void answerCheck(String Question) {
        int ans = 0;
        ans = (int) Question.charAt(0) - 48;
        System.out.println("Question is: " + Question);
        for (int i = 1; i <= Question.length(); i++) {
            String character = "*";
            int questionSign = Question.charAt(i);
            int checker = character.charAt(0);
            if (questionSign == checker) {
                ans = ans * (int) (Question.charAt(i + 1) - 48);
            }
            character = "/";
            questionSign = Question.charAt(i);
            checker = character.charAt(0);
            if (questionSign == checker) {
                ans = ans / (int) (Question.charAt(i + 1) - 48);
            }
            character = "+";
            questionSign = Question.charAt(i);
            checker = character.charAt(0);
            if (questionSign == checker) {
                ans = ans + (int) (Question.charAt(i + 1) - 48);
            }
            character = "-";
            questionSign = Question.charAt(i);
            checker = character.charAt(0);
            if (questionSign == checker) {
                ans = ans - (int) (Question.charAt(i + 1) - 48);
            }
            i++;
            System.out.println("Answer is: " + ans);
        }
        answer = ans;
    }

    public void Delay() {
        new CountDownTimer(1000, 1000) {
            TextView responce = (TextView) findViewById(R.id.responce);

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                responce.setText("Time Remaining");
                sec.setText("Seconds");
            }
        }.start();
    }

    public void pointCalc() {
        TextView secsLeft = (TextView) findViewById(R.id.sec);
        int denominator = 10 - Integer.valueOf((String) secsLeft.getText());
        gameData.setScore(gameData.getScore()+(100 / denominator));
        System.out.println("------------CALCULATED SCORE--------------- " + gameData.getScore());
        System.out.println("------------Score update: " + gameData.getScore());
    }

    public void hintMode() {
        TextView hint = (TextView) findViewById(R.id.tries_remaining);
        //TextView tries_remaining = (TextView) findViewById(R.id.)
        if (gameData.isHintMode()) {
            qa.setText(question);
            hint.setText(gameData.getNumOfHints() + "");
        } else {
            LinearLayout mainLayout = (LinearLayout) this.findViewById(R.id.hintMode);
            mainLayout.setVisibility(LinearLayout.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        time.cancel();
        Context context = this;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage("Do you want to save this game?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Save_Retrieve_Game_Data saveGame = new Save_Retrieve_Game_Data(getApplicationContext());
                        System.out.println("Score: " + gameData.getScore());




                        saveGame.saveGameData(gameData);
                        //saveGame.retGameData(1);
                        startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // dialogBox = false;
                        dialog.cancel();
                        startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
