package org.example.dao;

import org.example.exception.ObjectNotFoundException;
import org.example.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    Optional<Student> find(int id);

    Student save(Student student) throws IllegalArgumentException;

    List<Student> findAll();

    void delete(int id) throws ObjectNotFoundException;

    void clear();

}
