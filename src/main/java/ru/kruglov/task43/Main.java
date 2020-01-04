package ru.kruglov.task43;
import ru.kruglov.task43.app.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Application uiHandler = new Application();
            uiHandler.appController();
        } catch (IOException e) {
            //ExceptionMessages.ERROR_RUN_APPLICATION.printMessage();
            e.printStackTrace();
        }
    }
}
