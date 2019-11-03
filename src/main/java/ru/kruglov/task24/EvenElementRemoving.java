package ru.kruglov.task24;

import java.util.Iterator;
import java.util.Set;

public class EvenElementRemoving {
    public Set<String> evenElementRemover(Set<String> set) {
        Iterator iterator =  set.iterator();
        while (iterator.hasNext()) {
            String element = (String)iterator.next();
            if(element.length()%2 == 0) {
                iterator.remove();
            }
        }
        return set;
    }
}
