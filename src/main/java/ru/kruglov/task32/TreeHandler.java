package ru.kruglov.task32;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TreeHandler {
    int countOfNodesInNewTree;
    int countOfLeafs;
    BranchCreator tree;

    TreeHandler(int count) {
        this.countOfNodesInNewTree = count;
    }

    public void startComputing() {
        this.tree = createTree();
        countLeafs(this.tree);
        System.out.println("\nCOUNT OF LEAFS = " + this.countOfLeafs);
    }

    private BranchCreator createTree() {
        BranchCreator branchCreator = new BranchCreator(this.countOfNodesInNewTree);
        branchCreator.count();
        branchCreator.setChildForNodes();
        return branchCreator;
    }

    void getChildByParentId(BranchCreator branchCreator, int idOfParent) {
        HashMap<Integer, Node> hashMapOfNodes = branchCreator.getHashMapOfNodes();
        Node node = hashMapOfNodes.get(idOfParent);
        if (node != null) {
            System.out.println("ID of node = " + idOfParent);
            Node leftChild = node.getLeftChild();
            if (leftChild != null) {
                System.out.print("LChild = " + leftChild.getId() + "; ");
            }
            Node rightChild = node.getRightChild();
            if (rightChild != null) {
                System.out.print("RChild = " + rightChild.getId() + "\n");
            }
        }
    }

    private void countLeafs(BranchCreator branchCreator) {
        HashMap<Integer, Node> hashMapOfNodes = branchCreator.getHashMapOfNodes();
        this.countOfLeafs = 0;

        Iterator it = hashMapOfNodes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Node node = (Node)pair.getValue();
            //System.out.println("!!=" + node.getId());
            if (node.isLeaf() == true) {
                countOfLeafs++;
            }
        }
    }

}
