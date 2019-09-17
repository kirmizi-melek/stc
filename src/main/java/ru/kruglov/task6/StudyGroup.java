package ru.kruglov.task6;

public class StudyGroup extends Department {
    private int groupNumber;
    private int countOfStudents;

    public int getGroupNumber() {
        return groupNumber;
    }

    public int getCountOfStudents() {
        return countOfStudents;
    }

    @Override
    public void printName() {
        System.out.println("Я группа в Университете " + name);
    }

    StudyGroup(String newName,
               String newAddress,
               String newSpeciality,
               int newGrpoupNumber,
               int newCountOfStudents) {
        super(newName, newAddress, newSpeciality);
        this.groupNumber = newGrpoupNumber;
        this.countOfStudents = newCountOfStudents;
    }
}