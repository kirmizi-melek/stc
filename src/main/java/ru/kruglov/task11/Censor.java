package ru.kruglov.task11;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Censor {
    private boolean appStatus;
    private BufferedReader buff;
    private String uncensoredPhrase;
    private String censoredPhrase;
    private String uncensoredWord = "бяка";
    private String replacedCensoredWord = "<вырезано цензурой>";

    Censor() {
        this.appStatus = true;
        this.buff = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getCensoredPhrase() {
        return censoredPhrase;
    }

    private void setCensoredPhrase() {
        this.censoredPhrase = censorPhrase();
    }

    void start() throws IOException {
        while (appStatus){
            System.out.println(Responses.HELLO.getText());
            uncensoredPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
            if (uncensoredPhrase.equals("exit")){
                appStatus = false;
            } else {
                setCensoredPhrase();
                System.out.println(getCensoredPhrase());
            }
        }
    }

    private String censorPhrase() {
        String sentence = uncensoredPhrase;
        ArrayList<String> arraylist =new ArrayList<String>();
        arraylist.add(uncensoredWord);
        StringBuffer stringBuffer = new StringBuffer(100);
        String[] words = sentence.split("[ ,.;?!\"()]" );

        for(String word: words){
            System.out.println(word);
            if(arraylist.contains(word.toLowerCase())) {
                stringBuffer.append(replacedCensoredWord);
            } else {
                stringBuffer.append(word);
            }
        }
        return stringBuffer.toString();
    }
}
