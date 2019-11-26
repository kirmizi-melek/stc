package ru.kruglov.task33;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class MaximumRepeatableCharFind {
    private String inputWord;
    private char maxRepeatableChar;
    private HashMap<Character, Integer> hashMapOfCharsFromWord;

    MaximumRepeatableCharFind(BufferedReader buff) {
        try {
            this.inputWord = buff.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String returnFirstUnrepeatableChar() {
        try {
            this.hashMapOfCharsFromWord = createHashMapOfChars();
            findMaxRepeatableChar(this.hashMapOfCharsFromWord);
            return Character.toString(maxRepeatableChar);
        } catch (RuntimeException e) {
            //System.out.println("No chars, which repeats once");
            return "No chars, which repeats once";
        }
    }

    private HashMap<Character, Integer> createHashMapOfChars() {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inputWord.length(); i++) {
            char c = inputWord.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        return hashMap;
    }

    private void findMaxRepeatableChar(HashMap<Character, Integer> hashMap) throws RuntimeException{
        boolean statusOfSearch = false;
        int maxValue = 0;
        for (int i = 0; i < inputWord.length(); i++) {
            char character = inputWord.charAt(i);
            if (hashMap.get(character) > maxValue) {
                maxValue = hashMap.get(character);
                //this.maxRepeatableChar = character;
                //statusOfSearch = true;
                //break;
            }
        }

        for (int i = 0; i < inputWord.length(); i++) {
            char character = inputWord.charAt(i);
            if (hashMap.get(character) == maxValue) {
                //maxValue = hashMap.get(character);
                this.maxRepeatableChar = character;
                statusOfSearch = true;
                break;
            }

        }
        if (!statusOfSearch) {
            throw new RuntimeException(Messages.ERROR_APP_HANDLER.getMessage());
        }
    }
}
