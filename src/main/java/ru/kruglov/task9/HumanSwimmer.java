package ru.kruglov.task9;

public class HumanSwimmer extends Human {
    @Override
    protected String getName() {
        return null;
    }

    @Override
    public void swim() {
        this.endurance *= 2;
        super.swim();
    }
}
