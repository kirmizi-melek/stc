package ru.kruglov.task7;

import java.io.IOException;
import static ru.kruglov.task7.Drink.*;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private void start() {
        VendingMachine.UserInterfaceHandler vendingMachineHandler = new VendingMachine("Coca-Cola", COCACOLA,PEPSI ).new UserInterfaceHandler();
        try {
            vendingMachineHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
