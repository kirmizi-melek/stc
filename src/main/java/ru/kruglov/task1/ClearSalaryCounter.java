package ru.kruglov.task1;

public class ClearSalaryCounter {
    private static int NDFL = 13;
    private int dirtSalary;

    ClearSalaryCounter(int salary) {
        if (salary > 0) {
            this.dirtSalary = salary;
        } else {
            System.out.println("Value of salary is less or equal 0");
            System.exit(1);
        }
    }

    public float getClearSalary() {
        float clearSalary = dirtSalary / 100 * (100 - NDFL);
        return clearSalary;
    }
}
