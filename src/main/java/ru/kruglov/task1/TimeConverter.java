package ru.kruglov.task1;

public class TimeConverter {
    private int seconds;

    TimeConverter(int inputSeconds) {
        if (inputSeconds >= 0) {
            this.seconds = inputSeconds;
        } else {
            System.out.println("Value of seconds is less than 0");
            System.exit(1);
        }
    }

    public String getTimeInHours() {
        String outputTime;
        int hours = seconds / 3600;
        int minutes = (seconds / 60) % 60;
        outputTime = hours + " hour(s) " + minutes + " minute(s)";
        return outputTime;
    }
}
