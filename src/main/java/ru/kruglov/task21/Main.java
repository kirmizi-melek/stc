package ru.kruglov.task21;

public class Main {
    public static void main(String[] args) {
        //task21-1
        System.out.println("task21-1");
        new Main().twoDimensionalArrayAction();

        //task21-2
        System.out.println("task21-2");
        new Main().arrayReverseAction();
    }

    public void twoDimensionalArrayAction() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = {99, -2, -3, -4, -5, -6, 1};
        int[][] arr = {arr1, arr2};
        TwoDimensionalArrayShifter arrayExample = new TwoDimensionalArrayShifter(arr);
        arrayExample.toLeft();
        int[][] arr_new = arrayExample.getArray();
        for (int i = 0; i < arr_new.length; i++) {
            for (int j = 0; j < arr_new[i].length; j++) {
                System.out.print(arr_new[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void arrayReverseAction() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] newArray = new ArrayReversal(array).reverse();
        for (int i : newArray) {
            System.out.print(i + " ");
        }
    }
}
