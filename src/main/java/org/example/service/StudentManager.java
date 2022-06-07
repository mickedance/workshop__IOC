package org.example.service;

import org.example.exception.ObjectNotFoundException;
import org.example.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentManager {
    Student createAndSave();

    Student save(Student student);

    Optional<Student> find(int id);

    void remove(int id) throws ObjectNotFoundException;

    List<Student> findAll();

    Student edit(Student student);

    void clear();
}
