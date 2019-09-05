package ru.kruglov.task1;

public class Main {
    public static void main(String Args[]) {
        GasolineCounter gc = new GasolineCounter(100);
        ClearSalaryCounter tc = new ClearSalaryCounter(20000);
        TimeConverter timeConverter = new TimeConverter(0);
        System.out.println(timeConverter.getTimeInHours());
    }
    }
