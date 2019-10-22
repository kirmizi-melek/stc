package ru.kruglov.task14;

import ru.kruglov.localLibs.InputDataHandle;
import ru.kruglov.task14.vendingMachine.Drink;
import ru.kruglov.task14.vendingMachine.DrinkNotFoundException;
import ru.kruglov.task14.vendingMachine.NoMoneyException;
import ru.kruglov.task14.vendingMachine.VendingMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

import static ru.kruglov.task14.LoggerExample.LOGGER;

public class UserInterfaceHandler {
    private boolean appStatus = true;
    private BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    private VendingMachine vendingMachine;

    private void printMenu() {
        System.out.println(Response.PRICELIST.getText());
        for (Drink drink : vendingMachine.getDrinks()) {
            System.out.println(drink.id + ") " +
                    drink.name + " : " +
                    drink.price + " " +
                    Response.CURRENCY.getText());
        }
        LOGGER.log(Level.INFO, "User requested menu");
    }

    void start(VendingMachine vendingMachine) throws IOException {
        this.vendingMachine = vendingMachine;
        System.out.println(vendingMachine.getBrand() +"\n"+ Response.WELCOME.getText());
        while (appStatus) {
            String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
            switch (inputPhrase) {
                case ("exit") :
                    System.out.println(Response.GOODBYE.getText());
                    LOGGER.log(Level.INFO, "User left the vending machine");
                    appStatus = false;
                    break;
                case ("menu") :
                    printMenu();
                    break;
                case ("help") :
                    System.out.println(Response.HELP.getText());
                    LOGGER.log(Level.INFO, "User asked the help");
                    break;
                case ("deposit"):
                    System.out.println(Response.PUT_MONEY.getText());
                    try {
                        int money = Integer.parseInt(InputDataHandle.getDataFromSystemIn(this.buff));
                        vendingMachine.takeMoney(money);
                        System.out.println(Response.CURRENT_DEPOSIT.getText() + vendingMachine.getDepositSum());
                        break;
                    } catch (IOException | NumberFormatException e) {
                        System.out.println(Response.WRONG_INPUT.getText());
                        LOGGER.log(Level.WARNING, "Error with adding coins into vending machine", e);
                        break;
                    }
                case ("drink"):
                    System.out.println(Response.SELECT_DRINK.getText());
                    try {
                        int drinkID = Integer.parseInt(InputDataHandle.getDataFromSystemIn(this.buff));
                        vendingMachine.makeDeal(drinkID);
                        System.out.println( vendingMachine.getDrink() +  vendingMachine.getSelectedDrink(drinkID));
                        System.out.println("Your deposit balance: " + vendingMachine.getDepositSum());
                        break;
                    } catch (NoMoneyException e) {
                        System.out.println(Response.NOT_ENOUPH_MONEY.getText());
                        LOGGER.log(Level.INFO, "User tried to order drink not having enough money");
                        break;
                    }  catch (IOException | NullPointerException e) {
                        System.out.println(Response.WRONG_INPUT.getText());
                        LOGGER.warning(e.toString());
                        break;
                    }  catch (DrinkNotFoundException e) {
                        LOGGER.log(Level.INFO, "User selected wrong drink id");
                        System.out.println(Response.WRONG_DRINK_ID.getText());
                        break;
                    }
                case ("change"):
                    System.out.println(Response.TAKE_CHANGE.getText() + vendingMachine.getChange());
                    break;
                case ("check"):
                    System.out.println(Response.CURRENT_DEPOSIT.getText() + vendingMachine.getDepositSum());
                    LOGGER.log(Level.INFO, "User checked the balance");
                    break;
                default:
                    System.out.println(Response.WRONG_INPUT.getText());
                    LOGGER.log(Level.INFO, "User typed wrong command");
                    break;
            }
        }
    }
}
