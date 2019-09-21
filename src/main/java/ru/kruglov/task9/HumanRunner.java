package ru.kruglov.task9;

public class HumanRunner extends Human {
    @Override
    public void run() {
        super.speed *= 2;
        super.run();
    }


    @Override
    protected String getName() {
        return this.name;
    }
}
