package ru.kruglov.task13;

public enum Food {
    CARROT(false),
    PORRIGE(false),
    MILK(true),
    APPLE(true),
    SOUP(false);

    private boolean isTasty;

    Food(boolean isTasty) {
        this.isTasty = isTasty;
    }

    public boolean getTaste() {
        return this.isTasty;
    }
}
