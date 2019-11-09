package ru.kruglov.task27;

public class Fibonacci {
    //int quantity;

    public int[] getFibonacciArrayByIteration(int countOfNumerics) {
        int numeric = 1;
        int i = 1;
        int penultiamteNumeric, ultimateNumeric = 0;
        int[] fibonacciArray = new int[countOfNumerics];
        fibonacciArray[i-1] = 0;
        while (i < countOfNumerics) {
            fibonacciArray[i] = numeric;
            penultiamteNumeric = ultimateNumeric;
            ultimateNumeric = numeric;
            numeric = penultiamteNumeric + ultimateNumeric;
            i++;
        }
        return fibonacciArray;
    }


    private int fibonacci(int countOfNumerics) {
        if (countOfNumerics == 0)
            return 0; // базовый случай (условие завершения)
        if (countOfNumerics == 1)
            return 1; // базовый случай (условие завершения)
        return fibonacci(countOfNumerics-1) + fibonacci(countOfNumerics-2);
    }

    int[] getFibonacciArrayByRecursion(int countOfNumerics) {
        int[] fibonacciArray = new int[countOfNumerics];
        for (int i=0; i < countOfNumerics; ++i) {
            fibonacciArray[i] = fibonacci(i);
        }
        return fibonacciArray;
    }

}
