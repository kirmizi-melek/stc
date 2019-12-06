package ru.kruglov.task32;

public class Tree {
    Node root;

    int countOfLeafs;

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
        countLeafs(root);
        System.out.println("Count of Leafs = " + countOfLeafs);
    }


    private void printTree(Node currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode.getId());
            printTree(currentNode.getLeftChild());
            printTree(currentNode.getRightChild());
        }
    }

    private void countLeafs(Node currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode.getId());
            if(!currentNode.isLeaf()) {
                countLeafs(currentNode.getLeftChild());
                countLeafs(currentNode.getRightChild());
            } else {
                countOfLeafs++;
            }
        }
    }



}
