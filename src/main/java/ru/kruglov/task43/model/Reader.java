package ru.kruglov.task43.model;

import dnl.utils.text.table.TextTable;

public class Reader {
    private int id;
    private String name;

    public Reader(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TextTable getInstanceDataInPrettyTable(){
        String[] columnNames = {"id","name"};
        String[][] data = {{Integer.toString(this.getId()), this.getName()}};
        TextTable textTable = new TextTable(columnNames, data);
        return textTable;
    }
}
