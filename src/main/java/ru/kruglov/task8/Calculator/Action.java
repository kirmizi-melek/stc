package ru.kruglov.task8.Calculator;

public class Action {

    private static double addition(double firstValue,
                                   double secondValue) throws ArithmeticException{
        return firstValue + secondValue;
    }

    private static double substraction(double firstValue,
                                       double secondValue) throws ArithmeticException{
        return firstValue - secondValue;
    }

    private static double multiplication(double firstValue,
                                         double secondValue) throws ArithmeticException {
        return firstValue * secondValue;
    }

    private static double division(double firstValue,
                                   double secondValue) throws ArithmeticException {
        return firstValue / secondValue;
    }

    private static double percentage(double firstValue,
                                     double secondValue) throws ArithmeticException {
        return firstValue / secondValue *100;
    }

    static double action(double firstValue,
                         double secondValue,
                         String arithmeticAction) throws ArithmeticException {
        switch (arithmeticAction) {
            case ("+"):
                return addition(firstValue, secondValue);
            case ("-"):
                return substraction(firstValue, secondValue);
            case ("*"):
                return multiplication(firstValue, secondValue);
            case ("/"):
                return division(firstValue, secondValue);
            case ("%"):
                return percentage(firstValue, secondValue);
        }
        return 0;
    }

}
