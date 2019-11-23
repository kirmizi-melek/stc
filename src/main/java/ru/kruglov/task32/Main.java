package ru.kruglov.task32;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        new Main().createTreeAndCountLeafs(1007); //Set here count of nodes in new tree
    }

    void createTreeAndCountLeafs(int countOfNodesInNewTree) {
        BranchCreator branchCreator = new BranchCreator(countOfNodesInNewTree);
        branchCreator.count();
        branchCreator.setChildForNodes();

        HashMap<Integer, Node> hashMapOfNodes = branchCreator.getHashMapOfNodes();
        int countOfLeafs = 0;

        Iterator it = hashMapOfNodes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Node node = (Node)pair.getValue();
            //System.out.println("!!=" + node.getId());
            if (node.isLeaf() == true) {
                countOfLeafs++;
            }
        }
        System.out.println("\nCOUNT OF LEAFS = "+countOfLeafs);
    }
}
