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
        int num = 1;
        for (int i = 1; i <= countOfNodes; i++) {
            for (int j = 1; j <= num ; j++) {
                Node node = new Node(countOfNodes);
                System.out.println(node.getId());
                countOfNodes--;
            }
            num = num * 2;

            System.out.println("i="+i + "; num ="+num );
        }
    }
}
