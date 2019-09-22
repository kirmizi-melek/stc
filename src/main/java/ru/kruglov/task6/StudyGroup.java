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

    StudyGroup(String newName,
               String newAddress,
               String newSpeciality,
               int newGroupNumber,
               int newCountOfStudents) {
        super(newName, newAddress, newSpeciality);
        this.groupNumber = newGroupNumber;
        this.countOfStudents = newCountOfStudents;
    }

    @Override
    public String getName() {
        return "Group " + super.name;
    }
}
