package ru.kruglov.task8.Calculator;

public class Action {
    public static double addition(double firstValue, double secondValue) throws ArithmeticException{
        return firstValue + secondValue;
    }

    public static double substraction(double firstValue, double secondValue) throws ArithmeticException{
        return firstValue - secondValue;
    }

    public static double multiplication(double firstValue, double secondValue) throws ArithmeticException {
        return firstValue * secondValue;
    }

    public static double division(double firstValue, double secondValue) throws ArithmeticException {
        return firstValue/secondValue;
    }

    public static double percentage(double firstValue, double secondValue)throws ArithmeticException {
        return firstValue/secondValue*100;
    }
}
