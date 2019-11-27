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


    private void printTree(Node currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode.getId());
            printTree(currentNode.getLeftChild());
            printTree(currentNode.getRightChild());
        }
    }


}
