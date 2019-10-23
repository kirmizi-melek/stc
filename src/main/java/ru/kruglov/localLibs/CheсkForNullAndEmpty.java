package ru.kruglov.localLibs;

public class CheсkForNullAndEmpty {
    public static boolean checker(String[] arrayOfParameters) {
        boolean returnValue = true;
        for (String str: arrayOfParameters) {
            if ((str == null || str.equals("")) ) {
                returnValue = false;
                break;
            }
        }
        return returnValue;
    }
}
