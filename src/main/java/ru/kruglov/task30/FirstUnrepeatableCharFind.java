package ru.kruglov.task30;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class FirstUnrepeatableCharFind {
    private String inputWord;
    private char firstUnrepeatableChar;
    private HashMap<Character, Integer> hashMapOfCharsFromWord;

    FirstUnrepeatableCharFind(BufferedReader buff) {
        try {
            this.inputWord = buff.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String returnFirstUnrepeatableChar() {
        try {
            this.hashMapOfCharsFromWord = createHashMapOfChars();
            findFirstNonRepeatedCharacter(this.hashMapOfCharsFromWord);
            return Character.toString(firstUnrepeatableChar);
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

    private void findFirstNonRepeatedCharacter(HashMap<Character, Integer> hashMap) throws RuntimeException{
        boolean statusOfSearch = false;
        for (int i = 0; i < inputWord.length(); i++) {
            char character = inputWord.charAt(i);
            if (hashMap.get(character)==1) {
                this.firstUnrepeatableChar = character;
                statusOfSearch = true;
                break;
            }
        }
        if (!statusOfSearch) {
            throw new RuntimeException(Messages.ERROR_APP_HANDLER.getMessage());
        }
    }
}
