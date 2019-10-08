package ru.kruglov.task6;

public class Main {
    public static void main(String[] args) {
        Main maker = new Main();
        maker.make();
    }

    private void make() {
        StudyGroup groupOfStudy = new StudyGroup(
                "groupOfStudy",
                "IT",
                10,
                15
        );

        StudyGroup groupOfUniversity = new StudyGroup(
                "groupOfUniversity",
                "IT",
                20,
                30
        );

        University oxford = new University(
                "Oxford",
                "AddressOfOxford"
        );

        University cambridge = new University(
                "Cambridge",
                "AddressOfCambridge"
        );

        cambridge.addDepartment("CambridgeDepartment", "IT");
        cambridge.getDepartments();
        System.out.println(
            groupOfStudy.getName() + "\n"+
            groupOfUniversity.getName() + "\n" +
            oxford.getName() + "\n" +
            cambridge.getName()    + "\n" +
        );
    }
}
