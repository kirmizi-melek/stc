package ru.kruglov.task8.ClassCounter;

public class Class {
    private static int objectsCount = 0;

    Class () {
        objectsCount++;
    }

    static int getObjectsCount() {
        return objectsCount;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        objectsCount--;
    }
}
