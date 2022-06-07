package org.example.model.sequenser;

public class StudentSequencer {
    private static int id = 0;

    public static int getNext() {
        return ++id;
    }

    public static void reset() {
        id = 0;
    }

    public static int getCurrent() {
        return id;
    }
}
