package ru.kruglov.task9;

public class Duck extends Animal implements Running,Flying,Swimming {
    @Override
    protected String getName() {
        return this.name;
    }

    @Override
    public void flyUp() {
        String result = getName() + " is flying up";
        System.out.println(result);
    }

    @Override
    public void flyDown() {
        String result = getName() + " is flying down";
        System.out.println(result);
    }

    @Override
    public void run() {
        String result = getName() + " running";
        System.out.println(result);
    }

    @Override
    public void swim() {
        String result = getName() + " is swimming";
        System.out.println(result);
    }
}
