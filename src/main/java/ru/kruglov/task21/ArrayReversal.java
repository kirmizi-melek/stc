package ru.kruglov.task21;

public class ArrayReversal {
    int[] array;

    ArrayReversal(int[] inputArray) {
        this.array = inputArray;
    }

    public int[] reverse() {
        boolean status = true;
        int i = 0;
        int j = array.length-1;

        if (array.length % 2 == 0) {
            while (i != j-1) {
                arrayElementReplacer(i, j);
                i++; j--;
            }
        } else {
            while (i != j) {
                arrayElementReplacer(i,j);
                i++; j--;
            }
        }
        return array;
    }

    private void arrayElementReplacer(int i, int j) {
        int iTempValue, jTempValue;
        iTempValue = array[i];
        jTempValue = array[j];
        array[j] = iTempValue;
        array[i] = jTempValue;
    }
}
