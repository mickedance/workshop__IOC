package org.example.service;

import org.example.model.Student;

import java.util.List;

public interface StudentManager {
    Student createAndSave();
    Student save(Student student);
    Student find();
    void remove();
    List<Student> findAll();
    Student edit(Student student);

}
