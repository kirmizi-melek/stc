package ru.kruglov.task11;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Censor {
    private boolean appStatus;
    private BufferedReader buff;
    private String uncensoredPhrase;
    private String censoredPhrase;
    private String censoredWord = "бяка";
    private String replacedCensoredWord = "вырезано цензурой";

    Censor() {
        this.appStatus = true;
        this.buff = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() throws IOException {
        while (appStatus){
            System.out.println(Responses.HELLO.getText());
            uncensoredPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
            censorPhrase();
            System.out.println(censoredPhrase);
        }
    }

    private void censorPhrase() {
        censoredPhrase = uncensoredPhrase.replace(censoredWord, replacedCensoredWord);
    }
}
