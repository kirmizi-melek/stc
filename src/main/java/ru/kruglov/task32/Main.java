package ru.kruglov.task32;

public class Main {
    public static void main(String[] args) {
        //TreeHandler tree = new TreeHandler(22); //Set here count of nodes in new tree
        //tree.startComputing(); // Create tree and compute all its leafs
        //tree.getChildByParentId(tree.tree, 10); // Get childs' ids by parent id

        Tree tree = new Tree(100);
        for (int i = 0; i < 20; i++) {
            tree.addNode((int)(Math.random()*200));
        }

        tree.printTree();

        System.out.println("\n");
        tree.countLeafs();
    }
}
