package ru.kruglov.task1;

public class Main {
    public static void main(String Args[]) {
        GasolineCounter gasolineCounter = new GasolineCounter(100);
        ClearSalaryCounter salaryCounter = new ClearSalaryCounter(20000);
        TimeConverter timeConverter = new TimeConverter(8900);

        System.out.println(gasolineCounter.getGasolineCost());
        System.out.println(salaryCounter.getClearSalary());
        System.out.println(timeConverter.getTimeInHours());
    }
}
