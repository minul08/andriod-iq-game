package com.example.minul.iqgame;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Minul on 3/5/2016.
 */
public class Save_Retrieve_Game_Data {

    /** This application's preferences label */
    private static final String PREFS_NAME = "com.our.package.Save_Retrieve_Game_Data";
    /** This application's preferences */
    private static SharedPreferences settings;
    /** This application's settings editor*/
    private static SharedPreferences.Editor editor;
    /** Constructor takes an android.content.Context argument*/
    public Save_Retrieve_Game_Data(Context ctx){
        if(settings == null){
            settings = ctx.getSharedPreferences(PREFS_NAME,
                    Context.MODE_PRIVATE );
        }
       /*
        * Get a SharedPreferences editor instance.
        * SharedPreferences ensures that updates are atomic
        * and non-concurrent
        */
        editor = settings.edit();
    }

    public static final String KEY_PREFIX =
            "com.our.package.KEY";
    /** Method to return a unique key for any field belonging to a given object
     * @param id of the object
     * @param fieldKey of a particular field belonging to that object
     * @return key String uniquely identifying the object's field
     */
    private String getFieldKey(int id, String fieldKey) {
        return  KEY_PREFIX + id + "_" + fieldKey;
    }

    /** generic field keys */
    private static final String KEY_DIFFICULTY = "com.our.package.KEY_DIFFICULTY";
    private static final String KEY_NUMBEROFHINTS = "com.our.package.KEY_DIFFICULTYLEVEL";
    private static final String KEY_NUMBEROFQUESTIONS = "com.our.package.KEY_DIFFICULTYLEVEL";
    private static final String KEY_HINTMODE = "com.our.package.KEY_REGISTERED";
    private static final String KEY_SCORE = "com.our.package.KEY_SCORE";

    /** Store or Update */

    public void saveGameData(Game_Data gameDataSave){
        int id = gameDataSave.getId();
        editor.putString(getFieldKey(id, KEY_DIFFICULTY), gameDataSave.getDifficulty_level());
        editor.putInt(getFieldKey(id, KEY_SCORE), gameDataSave.getScore());
        editor.putBoolean(getFieldKey(id, KEY_HINTMODE), gameDataSave.isHintMode());
        editor.putInt(getFieldKey(id, KEY_NUMBEROFHINTS), gameDataSave.getNumOfHints());
        editor.putInt(getFieldKey(id, KEY_NUMBEROFQUESTIONS), gameDataSave.getNumberOfQuestions());
        editor.commit();

        System.out.println("Difficulty Level: " + gameDataSave.getDifficulty_level());
        System.out.println("Score is: " + gameDataSave.getScore());
        System.out.println("Hint Mode: " + gameDataSave.isHintMode());
        System.out.println("Number of hints is: " + gameDataSave.getNumOfHints());
        System.out.println("Number of Questions is: " + gameDataSave.getNumberOfQuestions());
        System.out.println("Game Saved");
        //editor.putString(getFieldKey(id, KEY_USERNAME), user.getNumOfHints() );

        //editor.putFloat(getFieldKey(id, KEY_SCORE), user.getScore() );

    }

    /** Retrieve */
    public void retGameData(int id) {

        String diffLevel = settings.getString(getFieldKey(id, KEY_DIFFICULTY), "");
        int score = settings.getInt(getFieldKey(id, KEY_SCORE), 0);
        boolean hintMode = settings.getBoolean(getFieldKey(id, KEY_HINTMODE), true);
        int numberOfHints = settings.getInt(getFieldKey(id, KEY_NUMBEROFHINTS), 0);
        int numberOfQuestions = settings.getInt(getFieldKey(id, KEY_NUMBEROFQUESTIONS), 0);

        Game_Data gameData = new Game_Data();
        gameData.setDifficulty_level(diffLevel);
        gameData.setScore(score);
        gameData.setHintMode(hintMode);
        gameData.setNumOfHints(numberOfHints);
        gameData.setNumberOfQuestions(numberOfQuestions);

        System.out.println("Difficulty Level: " + diffLevel);
        System.out.println("Score is: "+score);
        System.out.println("Hint Mode: "+hintMode);
        System.out.println("Number of hints is: "+numberOfHints);
        System.out.println("Number of Questions is: "+numberOfQuestions);
    }

    /** Delete */
    public void deleteUser(Game_Data user){
        if(user == null)
            return; // don't bother
        int id = user.getScore();
       // editor.remove( getFieldKey(id, KEY_USERNAME) );
        editor.remove( getFieldKey(id, KEY_HINTMODE) );
        editor.remove( getFieldKey(id, KEY_SCORE) );
        editor.commit();
    }


}
