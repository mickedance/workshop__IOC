package org.example.model;

import org.example.model.sequenser.StudentSequencer;

public class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student(){
        id = StudentSequencer.getNext();
    }

    public Student(String name){
        this();
        setName(name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null || name.trim().length()<1) throw new IllegalArgumentException("name was null or empty");
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
