package ru.kruglov.task32;


public class BranchCreator {
    void method(int countOfNodes) throws Exception {
        if (countOfNodes > 0) {
            for (int j = 1; j <= countOfNodes ; j++) {
                Node node = new Node(j);
            }
        } else throw new Exception();

    }

    void count(int countOfNodes) {
        int countOfNodesInTheLevel = 1;
        int idOfLevel = 1;
        int idOfNode = 1;
        while (countOfNodes > 0) {
            System.out.println("level="+idOfLevel + "; nodesInLevel ="+countOfNodesInTheLevel );
            for (int j = 0; (j < countOfNodesInTheLevel && countOfNodes>0); j++) {
                Node node = new Node(idOfNode);
                System.out.println("Node"+node.getId());
                idOfNode++;
                countOfNodes--;
            }
            idOfLevel++;
            countOfNodesInTheLevel = countOfNodesInTheLevel * 2;
        }
    }
}
