package ru.kruglov.task3.ClearSalary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClearSalaryCounter {
    private static final int NDFL = 13;
    private int dirtSalary;

    ClearSalaryCounter(int salary) {
        if (salary > 0) {
            this.dirtSalary = salary;
        } else {
            System.out.println("Value of salary is less or equal 0");
        }
    }

    private float getClearSalary() {
        float clearSalary = dirtSalary / 100 * (100 - NDFL);
        return clearSalary;
    }

    public static void main(String args[]) throws IOException {
        System.out.println("Type your total salary:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = buff.readLine();
        try {
            int salary = Integer.parseInt(inputValue);
            ClearSalaryCounter csc = new ClearSalaryCounter(salary);
            System.out.println("Your clear salary = " + csc.getClearSalary());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
