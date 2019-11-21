package ru.kruglov.task32;

public class Node {
    int id;
    Node leftChild;
    Node rightChild;

    Node(int id) {
        this.id = id;
    }

    public boolean isLeaf() {
        return (this.leftChild == null && this.rightChild == null);
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getId() {
        return id;
    }


}
