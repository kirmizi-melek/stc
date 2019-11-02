package ru.kruglov.task20;

import java.io.Serializable;

public class Fact implements Serializable {
    private String id;
    private String text;
    private String type;
    private User user;

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }
}
