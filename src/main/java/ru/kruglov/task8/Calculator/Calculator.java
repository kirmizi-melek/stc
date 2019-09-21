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
            String arithmeticAction = arithmeticActionSelector(inputPhrase);
            System.out.println(Responses.arithmeticActionResponses(inputPhrase));
            if (arithmeticAction != null) {
                System.out.println(Responses.INPUT_FIRST_VALUE.getText());
                double firstValue = Double.valueOf(InputDataHandle.getDataFromSystemIn(this.buff));
                System.out.println(Responses.INPUT_SECOND_VALUE.getText());
                double secondValue = Double.valueOf(InputDataHandle.getDataFromSystemIn(this.buff));
                System.out.println(Responses.RESULT.getText() +
                                   Action.action(firstValue,secondValue,arithmeticAction) +
                                   "\n");
            }
        }
    }

    private String arithmeticActionSelector(String userCommand) {
        String returnValue = null;
            switch (userCommand) {
                case("exit"):
                    appStatus = false;
                    break;
                case("addition"):
                case("+"):
                    returnValue = "+";
                    break;
                case("substraction"):
                case("-"):
                    returnValue = "-";
                    break;
                case("multiplication"):
                case("*"):
                    returnValue = "*";
                    break;
                case("division"):
                case(":"):
                case("/"):
                    returnValue = ":";
                    break;
                case("percentage"):
                case("%"):
                    returnValue = "%";
                    break;
                default:
                    break;
        }
        return returnValue;
    }
}
