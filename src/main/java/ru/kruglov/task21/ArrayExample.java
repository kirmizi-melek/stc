package ru.kruglov.task21;

public class ArrayExample {
    int[][] array;

    ArrayExample(int[][] inputArray) {
        this.array = inputArray;
    }
    public int[][] getArray() {
        return array;
    }


    public void toLeft() throws NullPointerException {
        //int[][] array = null;
        for (int i = 0; i < this.array.length ; i++) {
            for (int j = 0; j < this.array[i].length ; j++) {
                if (j+1 < this.array[i].length) {
                    array[i][j] = array[i][j + 1];
                } else {
                    array[i][j] = 0;
                }

            }

        }
    }
}
