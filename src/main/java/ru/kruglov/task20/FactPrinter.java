package ru.kruglov.task20;

import java.util.ArrayList;

public class FactPrinter {
    public void printFactfromArrayOfFacts(ArrayList<Fact> arrayOfFacts) {
        String factID;
        String factType;
        String factText;

        if (arrayOfFacts != null) {
            for (int i = 0; i < arrayOfFacts.size(); i++) {
                factText = arrayOfFacts.get(i).getText();
                factID = arrayOfFacts.get(i).getId();
                factType = arrayOfFacts.get(i).getType();
                System.out.printf("id = %s, type = %s \n%s \n\n",factID,factType,factText );
            }
        }

    }
}
