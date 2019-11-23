package ru.kruglov.task32;

import java.util.HashMap;

public class NodeCreator {
    Node node;
    int id;

    NodeCreator(int id) {
        this.id = id;
    }

    public Node createNode() {
        this.node = new Node(id);
        return node;
    }

    HashMap<Integer, Node> putNodesInHashMap(HashMap<Integer, Node> hashMapOfNodes) {
        //System.out.println(node.getId());
        hashMapOfNodes.put(node.getId(), node);
        return hashMapOfNodes;
    }
}
