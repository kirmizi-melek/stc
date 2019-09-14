package ru.kruglov.task4.Progressions;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.IOException;

public class EntryPoint {
    boolean appStatus = true;

    private void userInputHandler() throws IOException {
        System.out.println("Select progression. Type \"help\" for more info.");
        String inputPhrase = InputDataHandle.getDataFromSystemIn();
        if (inputPhrase.equals("exit")) {
            System.out.println("Application is being closing");
            appStatus = false;
        } else if (inputPhrase.equals("help")) {
            System.out.println("If you want to choose geomitric progression, type \"geometric\" or \"1\" \n" +
                    "in terminal window, if arithmetic - type \"arithmetic\" or \"2\"" +
                    " If you want to quit - type \"exit\"." +
                    "Thanks for using our application  + \n");

        } else if (inputPhrase.equals("geometric") || inputPhrase.equals("1")) {
            System.out.println("Geometric is chosen");
            String inputString = InputDataHandle.getDataFromSystemIn();
            int inputValue = getIntFromSystemIn(inputString);
            getElementsFromArray(GeometricProgression.getProgression(inputValue));

        } else if (inputPhrase.equals("arithmetic") || inputPhrase.equals("2")) {
            System.out.println("Arithmetic is chosen");
            String inputString = InputDataHandle.getDataFromSystemIn();
            int inputValue = getIntFromSystemIn(inputString);
            getElementsFromArray(ArithmeticProgression.getProgression(inputValue));
        }

    }

    private void getElementsFromArray (Integer[] arrayOfIntegers) {
        for(Integer element: arrayOfIntegers){
            System.out.println(element);
        }
    }

    private int getIntFromSystemIn(String string) throws IOException {
        return Integer.parseInt(string);
    }

    private void getGeometricProgression() {

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
