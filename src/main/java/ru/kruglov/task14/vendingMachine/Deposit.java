package ru.kruglov.task14.vendingMachine;

import java.util.logging.Level;

import static ru.kruglov.task14.LoggerExample.LOGGER;

class Deposit {
    private int depositeSum;

    void increaseDeposite(int depositeSum) {
        LOGGER.log (Level.INFO, "User increased his deposit from " + this.depositeSum +
                                     " to " + this.depositeSum + depositeSum + " rubles");
        this.depositeSum += depositeSum;
    }

    boolean priceAndDepositComparison(int drinkPrice) {
        return this.depositeSum >= drinkPrice;
    }

    int getChange() {
        int change = this.depositeSum;
        LOGGER.log (Level.INFO, "User returned back his deposit: " + change + " rubles" );
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
