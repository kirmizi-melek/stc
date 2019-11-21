package ru.kruglov.task32;

import java.util.HashMap;

public class NodeCreator {
    Node root = new Node(0);
    Node branch1 = new Node(1);
    Node branch2 = new Node(2);
    Node branch1_1 = new Node(3);
    Node branch1_2 = new Node(4);
    Node branch2_1 = new Node(5);
    Node branch2_2 = new Node(6);
    Node branch3_1 = new Node(7);

    NodeCreator() {
        createBranches();
    }

    void createBranches() {
        root.setLeftChild(branch1);
        root.setRightChild(branch2);
        branch1.setLeftChild(branch1_1);
        branch1.setRightChild(branch1_2);
        branch2.setLeftChild(branch2_1);
        branch2.setRightChild(branch2_2);
        branch2_1.setLeftChild(branch3_1);
    }

    HashMap<Integer, Node> putNodesInHashMap() {
        HashMap<Integer, Node> hashMapOfNodes = new HashMap<>();
        hashMapOfNodes.put(root.getId(), root);
        hashMapOfNodes.put(branch1.getId(), branch1);
        hashMapOfNodes.put(branch2.getId(), branch2);
        hashMapOfNodes.put(branch1_1.getId(), branch1_1);
        hashMapOfNodes.put(branch1_2.getId(), branch1_2);
        hashMapOfNodes.put(branch2_1.getId(), branch2_1);
        hashMapOfNodes.put(branch2_2.getId(), branch2_2);
        hashMapOfNodes.put(branch3_1.getId(), branch3_1);
        return hashMapOfNodes;
    }



}
