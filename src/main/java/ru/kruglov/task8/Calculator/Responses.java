package ru.kruglov.task8.Calculator;

public enum Responses {
    HELLO("Select operation"),
    WRONG_VALUE("Wrong command. Try again \n"),
    SELECTED_ACTION("\nSelected: "),
    INPUT_FIRST_VALUE("Input first value"),
    INPUT_SECOND_VALUE("Input second value"),
    EXIT("Application is being closed"),
    RESULT("Your resut: ");

    private String text;

    Responses(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static String arithmeticActionResponses(String userCommand) {
        String returnMessage = Responses.SELECTED_ACTION.getText();
        switch (userCommand) {
            case("exit"):
                returnMessage = Responses.EXIT.getText();
                break;
            case("addition"):
            case("+"):
                returnMessage += Commands.ADDITION.getText();
                break;
            case("substraction"):
            case("-"):
                returnMessage += Commands.SUBSTRACTION.getText();
                break;
            case("multiplication"):
            case("*"):
                returnMessage += Commands.MULTIPLICATION.getText();
                break;
            case("division"):
            case(":"):
            case("/"):
                returnMessage += Commands.DIVISION.getText();
                break;
            case("percentage"):
            case("%"):
                returnMessage += Commands.PERCENTAGE.getText();
                break;
            default:
                returnMessage = Responses.WRONG_VALUE.getText();
                break;
        }
        return returnMessage;
    }


}
