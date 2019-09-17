package ru.kruglov.task4.MinimalValue;

public class MinimalValue {
    private int firstValue;
    private int secondValue;

    MinimalValue(int value1, int value2) {
        try {
            this.firstValue = value1;
            this.secondValue = value2;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private int[] comparator() {
        int[] minimalValue = new int[2];
        if (firstValue > secondValue) {
            minimalValue[0] = secondValue;  // 0'th element means the minimal value
            minimalValue[1] = 1;            // 1'st element means the state
            //return secondValue;
        } else if (secondValue > firstValue) {
            minimalValue[0] = firstValue;
            minimalValue[1] = 1;
            //return firstValue;
        } else minimalValue[1] = 0;

        return minimalValue;
    }

    private String resulter() {
        String response;
        int[] result = comparator();
        if (result[1] == 0) {
            response = "Both numbers are equal";
        } else {
            response = "Number " + result[0] + " is the minimal";
        }
        return response;
    }

    private String handler() {
        comparator();
        return resulter();
    }


    public static void main(String[] args) {
        try {
            int firstArgument = Integer.parseInt(args[0]);
            int secondArgument = Integer.parseInt(args[1]);
            MinimalValue minimalValueInstance = new MinimalValue(firstArgument,secondArgument);
            System.out.println(minimalValueInstance.handler());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
