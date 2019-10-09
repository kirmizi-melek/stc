package ru.kruglov.task14;

import java.io.IOException;
import static ru.kruglov.task14.LoggerExample.LOGGER;
import java.util.logging.Level;

public class App {
    String vendingMachineName = "Coca-Cola";

    public static void main(String[] args) {
        LoggerExample.loggerConfig();
        App app = new App();
        app.start();
    }

    private void start() {
        VendingMachine.UserInterfaceHandler vendingMachineHandler;
        vendingMachineHandler = new VendingMachine(vendingMachineName, COCACOLA, PEPSI).new UserInterfaceHandler();
        try {
            LOGGER.log(Level.INFO, "Vending machine " + vendingMachineName + " started to work");
            vendingMachineHandler.start();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error with starting vending machine", e);
        }
    }
}