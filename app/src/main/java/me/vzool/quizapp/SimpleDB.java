package me.vzool.quizapp;

/**
 * This file was created to simplify Fingerprint access APIs
 * Created by vzool on 7/8/17.
 */

class SimpleDB {

    // a variable to cache answer for devil & angel question
    public static int devilAngelQuestionPoints = 0; // total 2

    // a variable to cache answer for number question
    public static int numbersQuestionPoints = 0; // total 2

    // a variable to cache answer for person name question
    public static int pinkColorQuestionPoints = 0; // total 1

    // a variable to cache answer for human colors question
    public static int humanColorsQuestionPoints = 0; // total 2

    // a variable to cache answer for peace decision question
    public static int peaceDecisionQuestionPoints = 0; // total 2

    // points calculator
    public static int Calculate(){

        int result = 0;

        result += devilAngelQuestionPoints;
        result += numbersQuestionPoints;
        result += pinkColorQuestionPoints;
        result += humanColorsQuestionPoints;
        result += peaceDecisionQuestionPoints;

        return result;
    }
}
