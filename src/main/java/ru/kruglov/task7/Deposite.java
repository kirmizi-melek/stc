package ru.kruglov.task7;

public class Deposite {
    private int depositeSum = 0;

    public int getDeposite() {
        return depositeSum;
    }

    public void setDeposite(int depositeSum) {
        this.depositeSum += depositeSum;
    }

    public boolean comparator(int drinkPrice) {
        return this.depositeSum >= drinkPrice;
    }

    public int getChange(int priceOfDrink) {
        return this.depositeSum - priceOfDrink;
    }
}
