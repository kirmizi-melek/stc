package ru.kruglov.task2.ClearSalary;

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

    public static void main(String Args[]) {
        try {
            String inputValue = Args[0];
            int salary = Integer.parseInt(inputValue);
            ClearSalaryCounter csc = new ClearSalaryCounter(salary);
            System.out.println(csc.getClearSalary());
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            aiobe.printStackTrace();
            System.exit(1);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            System.exit(1);
        }
    }
}
