package ru.kruglov.task3.Time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void main(String[] args) throws IOException {
        System.out.println("Type time in seconds:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = buff.readLine();
        try {
            int time = Integer.parseInt(inputValue);
            TimeConverter tc = new TimeConverter(time);
            System.out.println(tc.getTimeInHours());
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
            e.printStackTrace();
        }
    }
}
