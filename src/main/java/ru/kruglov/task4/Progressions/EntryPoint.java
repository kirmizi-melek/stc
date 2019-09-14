package ru.kruglov.task4.Progressions;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.IOException;

public class EntryPoint {
    boolean appStatus = true;

    private void userInputHandler() throws IOException {
        System.out.println(UIresponse.WELCOME.getText());
        String inputPhrase = InputDataHandle.getDataFromSystemIn();
        if (inputPhrase.equals("exit")) {
            System.out.println(UIresponse.GOODBYE.getText());
            appStatus = false;
        } else if (inputPhrase.equals("help")) {
            System.out.println(UIresponse.HELP.getText());

        } else if (inputPhrase.equals("geometric") || inputPhrase.equals("1")) {
            System.out.println(UIresponse.GEOMETRIC_CHOOSE.getText());
            String inputString = InputDataHandle.getDataFromSystemIn();
            int inputValue = getIntFromSystemIn(inputString);
            getElementsFromArray(GeometricProgression.getProgression(inputValue));

        } else if (inputPhrase.equals("arithmetic") || inputPhrase.equals("2")) {
            System.out.println(UIresponse.ARITHMETIC_CHOOSE.getText());
            String inputString = InputDataHandle.getDataFromSystemIn();
            int inputValue = getIntFromSystemIn(inputString);
            getElementsFromArray(ArithmeticProgression.getProgression(inputValue));
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
                instance.userInputHandler();
            } catch (IOException ioe) {
                instance = null;
                ioe.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        EntryPoint entryPoint = new EntryPoint();
        entryPoint.instanceCreator(entryPoint);

    }
}
