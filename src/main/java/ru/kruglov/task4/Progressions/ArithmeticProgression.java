package ru.kruglov.task4.Progressions;

public class ArithmeticProgression {

    public static Integer[] getProgression(int denominator) {

        Integer[] arrayOfIntegers = new Integer[10];
        arrayOfIntegers[0] = 1;
        int sumOfElements;
        for (int i = 1; i < 10; i++) {
            //sumOfElements = arrayOfIntegers[]
            arrayOfIntegers[i] = arrayOfIntegers[i-1]  + (i-1)*denominator;
        }

        return arrayOfIntegers;


    }

}
