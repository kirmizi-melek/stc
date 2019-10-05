package ru.kruglov.task14;

import java.io.IOException;
import java.util.logging.Logger;

import static ru.kruglov.task7.Drink.COCACOLA;
import static ru.kruglov.task7.Drink.PEPSI;

public class App {
    public static void main(String[] args) {
        LoggerExample.LOGGER.info("бла");

        App app = new App();
        app.start();
    }

    private void start() {
        VendingMachine.UserInterfaceHandler vendingMachineHandler = new VendingMachine("Coca-Cola",COCACOLA,PEPSI).new UserInterfaceHandler();
        try {
            vendingMachineHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
