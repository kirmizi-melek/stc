package ru.kruglov.task31;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class RevertWord {
    private String inputWord;
    private String outputWord;
    //private HashMap<Character, Integer> hashMapOfCharsFromWord;

    RevertWord(BufferedReader buff) {
        try {
            this.inputWord = buff.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void standartRevert() {
        String string = this.inputWord;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        //stringBuilder.reverse();
        //System.out.println(stringBuilder);
        this.outputWord = stringBuilder.reverse().toString();
    }

    void doubleSideRever() {
        char[] inputCharArray = this.inputWord.toCharArray();
        char tempChar;
        int begin = 0;
        int end = inputCharArray.length-1;
        while (end > begin) {
            tempChar = inputCharArray[begin];
            inputCharArray[begin] = inputCharArray[end];
            inputCharArray[end] = tempChar;
            end--; begin++;
        }
        this.outputWord = new String(inputCharArray);
    }

    public String getOutputWord() {
        return outputWord;
    }



}
