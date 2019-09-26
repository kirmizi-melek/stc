package ru.kruglov.task7;

class Deposit {
    private int depositeSum;

    void increaseDeposite(int depositeSum) {
        this.depositeSum += depositeSum;
    }

    boolean priceAndDepositComparison(int drinkPrice) {
        return this.depositeSum >= drinkPrice;
    }

    int getChange() {
        int change = this.depositeSum;
        depositeSum = 0;
        return change;
    }

    void decreaseDeposite(int priceOfDrink) {
        this.depositeSum -= priceOfDrink;
    }

    int getDeposit() {
        return depositeSum;
    }
}
