package org.example.model.sequenser;

public class StudentSequencer {
    private static int id=0;

    public static int getNext(){
        return ++id;
    }
}
