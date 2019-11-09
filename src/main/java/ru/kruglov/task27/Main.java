package ru.kruglov.task27;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fibonacci array by iteration");
        int[] stack1 = new Fibonacci().getFibonacciArrayByIteration(20);
        for (int i:stack1) {
            System.out.print(i+"|");
        }

        System.out.println("\nFibonacci array by recursion");
        int[] stack2 = new Fibonacci().getFibonacciArrayByRecursion(20);
        for (int i:stack2) {
            System.out.print(i+"|");
        }
    }
}
