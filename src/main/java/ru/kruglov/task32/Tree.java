package ru.kruglov.task32;

public class Tree {
    Node root;

    Tree(int id) {
       root = new Node(id);
    }

    public void addNode(int nodeId) {
        addNode(root, new Node(nodeId));
    }

    private void addNode(Node current, Node newNode ) {
        if (current.getId() < newNode.getId()) {
            if (current.getRightChild() == null) {
                current.setRightChild(newNode);
            } else {
                addNode(current.getRightChild(), newNode);
            }
        } else {
            if (current.getLeftChild() == null) {
                current.setLeftChild(newNode);
            } else {addNode(current.getLeftChild(), newNode);
            }
        }
    }

    public void printTree() {
        printTree(root);
    }

    public void countLeafs() {
        int count = countLeafs(root);
        System.out.println("Count of Leafs = " + count);
    }

    private void printTree(Node currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode.getId());
            printTree(currentNode.getLeftChild());
            printTree(currentNode.getRightChild());
        }
    }

    private int countLeafs(Node currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode.getId());
            if(!currentNode.isLeaf()) {
                int leftCount = countLeafs(currentNode.getLeftChild());
                int rightCount = countLeafs(currentNode.getRightChild());
                return leftCount+ rightCount;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
