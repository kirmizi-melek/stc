package ru.kruglov.task8.ClassCounter;

public class Main {
    public static void main(String[] args) throws Throwable {
        // Add five instances of a class
        Class firstClass = new Class();
        Class secondClass = new Class();
        Class thirdClass = new Class();
        Class fourthClass = new Class();
        Class fifthClass = new Class();
        // get count of instances
        System.out.println(Class.getObjectsCount()); // 5
        // delete one instance
        fifthClass.finalize();
        // get count of instances
        System.out.println(Class.getObjectsCount()); // 4
        // Add one more instance
        Class sixthClass = new Class();
        // get count of instances
        System.out.println(Class.getObjectsCount()); //5
    }
}
