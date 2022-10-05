package com.example.pizasson.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that helps to validate if any unwanted character or digit is entered.
 * 
 * @author Santiago Caballero
 */
public class RegularExpression {

    public static RegularExpression regularExpression;
    private Matcher matcher;

    /**
     * This method do the unique instance in all program of this class in case there isn't an instance of this class.
     *
     * @return RegularExpression to get the unique instance.
     */
    public static RegularExpression getRegularExpression() {
        if (regularExpression == null) {regularExpression = new RegularExpression();}
        return regularExpression;
    }

    /**
     * Method to validate letters or words inserted
     * @param answer the word to validate
     * @return true if the word has other character besides of letters
     */
    public boolean validateLetters(String answer) {
        Pattern regularExpressionNumbers = Pattern.compile("\\d");
        Pattern regularExpressionSymbols = Pattern.compile("[\\p{Punct}]");
        Matcher matcherNumbers = regularExpressionNumbers.matcher(answer);
        Matcher matcherSymbols = regularExpressionSymbols.matcher(answer);
        return (matcherNumbers.find() || matcherSymbols.find());
    }

    /**
     * Helps to verify if there are numbers in the entered answer.
     * Checks if the user entered just numbers and not symbols or letters
     * 
     * @param answer the numbers to validate
     * @return true if the answer has other character besides of numbers
     */
    public boolean validateNumbers(String answer){
        Pattern regularExpressionLetters = Pattern.compile("[a-zA-Z]");
        Pattern regularExpressionSymbols = Pattern.compile("[\\p{Punct}]");
        Matcher matchLetters = regularExpressionLetters.matcher(answer);
        Matcher matchSymbols = regularExpressionSymbols.matcher(answer);
        return (matchLetters.find() || matchSymbols.find());
    }

    /**
     * Helps to verify if there are symbols in the entered answer.
     * Checks if the user entered symbols in those fields where they should not be entered.
     * 
     * @param answer User entered answer
     * @return false if it contains no symbols and true if it contains 1 or more symbols.
     */

    public boolean validateSymbols(String answer) {
        Pattern regularExpressionSymbols = Pattern.compile("[\\p{Punct}]");
        matcher = regularExpressionSymbols.matcher(answer);
        return matcher.find();
    }

    /**
     * Method to match the answer received with a regular email expression to validate an email format
     * @param answer to compare with the regularExpression
     * @return true if the email matches with the email format and false if not
     */
    public boolean validateEmail(String answer) {
        Pattern regularExpressionEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        matcher = regularExpressionEmail.matcher(answer);
        return matcher.matches();
    }
}