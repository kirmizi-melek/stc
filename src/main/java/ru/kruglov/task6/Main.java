package ru.kruglov.task6;

public class Main {
    public static void main(String[] args) {
        Main maker = new Main();
        maker.make();
    }

    private void make() {
        StudyGroup groupOfStudy = new StudyGroup(
                "groupOfStudy",
                "Address1" ,
                "IT",
                10,
                15
        );

        University groupOfUniversity = new StudyGroup(
                "groupOfUniversity",
                "Address2" ,
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

        University department = new Department(
                "CambridgeDepartment",
                "Address",
                "IT"
        );

        System.out.println(
            groupOfStudy.getName() + "\n"+
            groupOfUniversity.getName() + "\n" +
            oxford.getName() + "\n" +
            cambridge.getName()    + "\n" +
            department.getName()
        );
    }
}
