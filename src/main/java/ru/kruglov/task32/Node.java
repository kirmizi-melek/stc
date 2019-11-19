package ru.kruglov.task32;

public class Node {
    int id;
    Node leftChild;
    Node rightChild;

    private boolean isLeaf() {
        return (this.leftChild == null && this.rightChild == null);
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
}
