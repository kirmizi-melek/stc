package ru.kruglov.task32;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BranchCreator {
    int countOfNodes;
    NodeCreator node;
    HashMap<Integer, Node> hashMapOfNodes = new HashMap<>();


    BranchCreator(int count) {
        this.countOfNodes = count;
    }

    public HashMap<Integer, Node> getHashMapOfNodes() {
        return hashMapOfNodes;
    }

    void count() {
        int countOfNodesInTheLevel = 1;
        int idOfLevel = 1;
        int idOfNode = 1;
        int totalNodes = countOfNodes;
        while (totalNodes > 0) {
            //System.out.println("level=" + idOfLevel + "; nodesInLevel =" + countOfNodesInTheLevel );
            for (int j = 0; (j < countOfNodesInTheLevel && totalNodes>0); j++) {
                node = new NodeCreator(idOfNode);
                node.createNode();
                hashMapOfNodes = node.putNodesInHashMap(hashMapOfNodes);
                idOfNode++;
                totalNodes--;
            }
            idOfLevel++;
            countOfNodesInTheLevel = countOfNodesInTheLevel * 2;
        }
    }

    void setChildForNodes() {
        Iterator it = hashMapOfNodes.entrySet().iterator();
        int countOfNodesInLevel = 1;
        int idOfLevel = 1;
        int idOfLChild, idOfRChild;

        while (it.hasNext()) {
            for (int i = 1; i <= countOfNodes; ) {
                int iterator = 0;
                for (int j = 1; j <= countOfNodesInLevel && i <= countOfNodes; j++, i++) {
                    Map.Entry pair = (Map.Entry) it.next();
                    Node parentNode = (Node)pair.getValue();
                    idOfLChild = i + countOfNodesInLevel + iterator;
                    iterator++;
                    idOfRChild = i + countOfNodesInLevel + iterator;
                    if (idOfLChild <= countOfNodes) {
                        parentNode.setLeftChild(hashMapOfNodes.get(idOfLChild));
                        System.out.printf("idLevel=%d;countOfNodesInLevel=%d,idParent=%d;idLChild=%d,",idOfLevel,countOfNodesInLevel,i,idOfLChild);
                    }
                    if (idOfRChild <= countOfNodes) {
                        parentNode.setRightChild(hashMapOfNodes.get(idOfRChild));
                        System.out.printf("idRChild=%d \n",idOfRChild);
                    }


                }
                countOfNodesInLevel *= 2;
                idOfLevel++;
            }

        }
    }
}
