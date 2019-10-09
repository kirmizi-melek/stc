package ru.kruglov.task6;

public class StudyGroup {
    private String name;
    private int groupNumber;
    private int countOfStudents;

    public int getGroupNumber() {
        return groupNumber;
    }

    public int getCountOfStudents() {
        return countOfStudents;
    }

    StudyGroup(String newName,
               int newGroupNumber,
               int newCountOfStudents) {
        this.name = newName;
        this.groupNumber = newGroupNumber;
        this.countOfStudents = newCountOfStudents;
    }

    public String getName() {
        return "Group " + name;
    }
}
