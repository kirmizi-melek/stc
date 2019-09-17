package ru.kruglov.task2.Time;

public class TimeConverter {
    private int seconds;

    TimeConverter(int inputSeconds) {
        if (inputSeconds >= 0) {
            this.seconds = inputSeconds;
        } else {
            System.out.println("Value of seconds is less than 0");
        }
    }

    private String getTimeInHours() {
        String outputTime;
        int hours = seconds / 3600;
        int minutes = (seconds / 60) % 60;
        outputTime = hours + " hour(s) " + minutes + " minute(s)";
        return outputTime;
    }

    public static void main(String[] args) {
        try {
            String inputValue  = args[0];
            int time = Integer.parseInt(inputValue);
            TimeConverter tc = new TimeConverter(time);
            System.out.println(tc.getTimeInHours());
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
            e.printStackTrace();
        }
    }
}
