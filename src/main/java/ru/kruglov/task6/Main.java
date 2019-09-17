package ru.kruglov.task6;

public class Main {
    public static void main(String[] args) {
        University groupOfIT = new StudyGroup(
                "MGU",
                "Address1" ,
                "IT",
                10,
                15);
        University univ = new University(
                "Cambridge",
                "Address11");
        printName(groupOfIT);
        printName(univ);

//        System.out.println(
//                groupOfIT.getName() + "\n" +
//                groupOfIT.getAddress() + "\n" +
//                groupOfIT.getSpeciality() + "\n" +
//                groupOfIT.getGroupNumber() + "\n" +
//                groupOfIT.getCountOfStudents());
//
    }

    private static void printName(University university) {
        university.printName();
    }
}
