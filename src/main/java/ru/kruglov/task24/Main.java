package ru.kruglov.task24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        EvenElementRemoving eer = new EvenElementRemoving();
        main.setPrinter(main.setPreparator());
        System.out.print("\n");
        main.setPrinter(eer.evenElementRemover(main.setPreparator()));

    }

    public Set<String> setPreparator() {
        Set<String> set = new HashSet<String>(
                Arrays.asList("foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"));
        return set;
    }

    public void setPrinter(Set<String> set) {
        Iterator iterator =  set.iterator();
        while (iterator.hasNext()) {
            System.out.printf("[%s]", iterator.next());
        }
    }


}
