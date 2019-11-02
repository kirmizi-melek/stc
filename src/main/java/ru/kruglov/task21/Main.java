package ru.kruglov.task21;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        int[] arr2 = {-1,-2,-3,-4,-5,-6,-7,-8,-9};
        int[][] arr = {arr1,arr2};
        ArrayExample arrayExample = new ArrayExample(arr);
        arrayExample.toLeft();
        int[][] arr_new = arrayExample.getArray();
        for (int i = 0; i <arr_new.length ; i++) {
            for (int j = 0; j <arr_new[i].length ; j++) {
                System.out.print(arr_new[i][j]);
            }
            System.out.print("\n");

        }
    }
}
