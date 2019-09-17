package ru.kruglov.task4.Progressions;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntryPoint {
    private boolean appStatus = true;

    private void userInputHandler() throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(UIresponse.WELCOME.getText());
        String inputPhrase = InputDataHandle.getDataFromSystemIn(buff);
        switch (inputPhrase) {
            case "exit":
                System.out.println(UIresponse.GOODBYE.getText());
                appStatus = false;
                break;
            case "help":
                System.out.println(UIresponse.HELP.getText());

                break;
            case "geometric":
            case "1": {
                System.out.print(UIresponse.GEOMETRIC_CHOOSE.getText());
                System.out.println(UIresponse.INPUT_DELIMITER.getText());
                String inputString = InputDataHandle.getDataFromSystemIn(buff);
                int inputValue = getIntFromSystemIn(inputString);
                getElementsFromArray(GeometricProgression.getProgression(inputValue));

                break;
            }
            case "arithmetic":
            case "2": {
                System.out.print(UIresponse.ARITHMETIC_CHOOSE.getText());
                System.out.println(UIresponse.INPUT_DELIMITER.getText());
                String inputString = InputDataHandle.getDataFromSystemIn(buff);
                int inputValue = getIntFromSystemIn(inputString);
                getElementsFromArray(ArithmeticProgression.getProgression(inputValue));
                break;
            }
        }
    }

    private void getElementsFromArray (Integer[] arrayOfIntegers) {
        for(Integer element: arrayOfIntegers){
            System.out.print(element + "; ");
        }
        System.out.println("\n");
    }

    private int getIntFromSystemIn(String string) throws IOException {
        return Integer.parseInt(string);
    }

    private void instanceCreator(EntryPoint instance) {
        while (this.appStatus) {
            try {
                assert instance != null;
                instance.userInputHandler();
            } catch (IOException ioe) {
                instance = null;
                ioe.printStackTrace();
            } catch (NumberFormatException nfe) {
                System.out.println(UIresponse.WRONG_INPUT_DATA.getText());
            }
        }
    }

    public static void main(String[] args) {
        EntryPoint entryPoint = new EntryPoint();
        entryPoint.instanceCreator(entryPoint);

    }
}
