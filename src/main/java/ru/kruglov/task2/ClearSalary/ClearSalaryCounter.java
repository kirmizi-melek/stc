package ru.kruglov.task2.ClearSalary;

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
        return (float) (dirtSalary / 100 * (100 - NDFL));
    }

    public static void main(String[] args) {
        try {
            String inputValue = args[0];
            int salary = Integer.parseInt(inputValue);
            ClearSalaryCounter csc = new ClearSalaryCounter(salary);
            System.out.println(csc.getClearSalary());
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
