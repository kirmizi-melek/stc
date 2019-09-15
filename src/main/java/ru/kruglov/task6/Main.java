package ru.kruglov.task6;

public class Main {
    public static void main(String[] args) {
        StudyGroup groupOfIT = new StudyGroup(
                "FacultyOfIT",
                "Address1" ,
                "IT",
                10,
                15);
        System.out.println(
                groupOfIT.getName() + "\n" +
                groupOfIT.getAddress() + "\n" +
                groupOfIT.getSpeciality() + "\n" +
                groupOfIT.getGroupNumber() + "\n" +
                groupOfIT.getCountOfStudents());

    }
}
