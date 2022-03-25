package com.jasonli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class that used to handle string.
 * @author Jason Zhixin Li
 * @version 1.0.0
 */
public class StringHandler {
    /**
     * Regix pattern that use to check whether got 3 consecutive characters appear
     */
    private static final String PATTERN1 = "(.)\\1{2,}";

    /**
     * Class variable
     */
    private String targetStr;

    /**
     * Getter of variable targetStr.
     * @return The value of targetStr
     */
    public String getTargetStr() {
        return targetStr;
    }

    /**
     * Setter of variable targetStr
     * @param targetStr The new value that you want to set.
     */
    public void setTargetStr(String targetStr) {
        this.targetStr = targetStr;
    }

    /**
     * The default constructor.
     */
    public StringHandler() {
    }

    /**
     * The constructor with param.
     * @param targetStr The string that you want to handle.
     */
    public StringHandler(String targetStr) {
        this.targetStr = targetStr;
    }

    /**
     * A function to check the target string is lower case or not
     * @return True: mean all chars in string are lower case.
     *         False: mean at least got 1 letter is not lower case.
     */
    public boolean isAlphabet() {
        return ((targetStr != null) && (!targetStr.isBlank()) && (targetStr.chars().allMatch(Character::isLowerCase)));
    }

    /**
     * A fuction to check whether string got 3 consecutive characters appear
     * @return True: mean got at least 1 letter got 3 consecutive characters appear.
     *         False: mean no letter 3 consecutive characters appear.
     */
    public boolean isValidStr() {
        Pattern p = Pattern.compile(PATTERN1);
        Matcher m = p.matcher(targetStr);

        if(m.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A function to remove the letter that got 3 consecutive characters appear
     */
    public void handleStrBasic() {
        Pattern p = Pattern.compile(PATTERN1);
        Matcher m = p.matcher(targetStr);

        if(m.find()) {
            targetStr = targetStr.replace(m.group(0), "");
            System.out.println(targetStr);
        } else {
            System.out.println(targetStr);
        }
    }

    /**
     * A function to replace the letter that got 3 consecutive characters appear to a single character that comes before it alphabetically.
     */
    public void handleStrAdvance() {
        Pattern p = Pattern.compile(PATTERN1);
        Matcher m = p.matcher(targetStr);
        var replaceIndex = 0;
        var replaceChar = "";

        if(m.find()) {
            if(targetStr.indexOf(m.group(0))>0) {
                replaceIndex = targetStr.indexOf(m.group(0)) - 1;
                replaceChar = targetStr.substring(replaceIndex, replaceIndex+1);
                targetStr = targetStr.replace(m.group(0), replaceChar);
                System.out.printf("%s, %s is replaced by %s \n", targetStr, m.group(0), replaceChar);
            } else {
                targetStr = targetStr.replace(m.group(0), "");
                System.out.println(targetStr);
            }
        } else {
            System.out.println(targetStr);
        }
    }
}
