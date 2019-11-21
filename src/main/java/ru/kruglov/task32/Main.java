package ru.kruglov.task32;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Node> hashMapOfNodes = new NodeCreator().putNodesInHashMap();
        int countOfLeafs = 0;
        Iterator it = hashMapOfNodes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Node node = (Node)pair.getValue();
            if (node.isLeaf() == true) {
                countOfLeafs++;
            }
        }
        System.out.println(countOfLeafs);
    }


}
