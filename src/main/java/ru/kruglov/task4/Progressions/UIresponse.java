package ru.kruglov.task4.Progressions;

public enum UIresponse {
    WELCOME ("Select progression. Type \"help\" for more info."),
    HELP("If you want to choose geomitric progression, type \"geometric\" or \"1\" \n" +
            "in terminal window, if arithmetic - type \"arithmetic\" or \"2\"." +
            "\nIf you want to quit - type \"exit\". Thanks for using our application. \n"),
    GOODBYE("Application is being closing"),
    GEOMETRIC_CHOOSE("Geometric is chosen"),
    ARITHMETIC_CHOOSE("Arithmetic is chosen");

    private String text;

    UIresponse(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
