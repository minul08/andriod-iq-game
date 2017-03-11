package com.example.minul.iqgame;

/**
 * Created by Minul on 3/1/2016.
 */
public class Game_Data {
    public static int id;
    public static String difficulty_level;
    public static int score;
    public static boolean hintMode;
    public static int numOfHints;
    public static int numberOfQuestions;

    public static boolean isCont() {
        return cont;
    }

    public static void setCont(boolean cont) {
        Game_Data.cont = cont;
    }

    public static boolean cont;

    public static int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public static void setNumberOfQuestions(int numberOfQuestions) {
        Game_Data.numberOfQuestions = numberOfQuestions;
    }



    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Game_Data.id = id;
    }



    public static int getNumOfHints() {
        return numOfHints;
    }

    public static void setNumOfHints(int numOfHints) {
        Game_Data.numOfHints = numOfHints;
    }



    public static boolean isHintMode() {
        return hintMode;
    }

    public static void setHintMode(boolean hintMode) {
        Game_Data.hintMode = hintMode;
    }



    public static String getDifficulty_level() {
        return difficulty_level;
    }

    public static void setDifficulty_level(String difficulty_level) {
        Game_Data.difficulty_level = difficulty_level;
    }


    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Game_Data.score = score;
    }


}
