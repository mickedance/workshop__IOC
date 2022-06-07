package org.example.model;

import org.example.model.sequenser.StudentSequencer;

import java.util.Objects;

public class Student {
    String name;
    int id;

    public Student(String name, int id) {
        setName(name);
        setId(id);
    }

    public Student() {
        id = StudentSequencer.getNext();
    }

    public Student(String name) {
        this();
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 1) throw new IllegalArgumentException("name was null or empty");
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
