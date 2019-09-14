package ru.kruglov.task4.Progressions;

public class GeometricProgression {

    public static Integer[] getProgression(int denominator) {
        Integer[] arrayOfIntegers = new Integer[10];
        arrayOfIntegers[0] = 1;
        for (int i = 1; i < 10; i++) {
            arrayOfIntegers[i] = arrayOfIntegers[i-1] * denominator;
        }
        return arrayOfIntegers;
    }
}
