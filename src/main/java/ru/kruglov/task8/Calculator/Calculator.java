package ru.kruglov.task8.Calculator;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Calculator {
    private boolean appStatus;
    private BufferedReader buff;

    Calculator() {
        this.appStatus = true;
        this.buff = new BufferedReader(new InputStreamReader(System.in));
    }

    void start() throws IOException {
        while (appStatus) {
            System.out.println(Responses.HELLO.getText());
            String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
            switch (inputPhrase) {
                case("exit"):
                    appStatus = false;
                    continue;
                case("addition"):
                case("+"):
                    System.out.println("Selected addition \n");
                    break;
                case("substraction"):
                case("-"):
                    System.out.println("Selected substraction \n");
                    break;
                case("multiplication"):
                case("*"):
                    System.out.println("Selected multiplication \n");
                    break;
                case("division"):
                case(":"):
                case("/"):
                    System.out.println("Selected division \n");
                    break;
                default:
                    System.out.println("Wrong command. Try again \n");
                    break;
            }

        }
    }

}
