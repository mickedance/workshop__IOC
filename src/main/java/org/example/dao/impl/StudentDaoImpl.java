package org.example.dao.impl;

import org.example.dao.StudentDao;
import org.example.exception.ObjectNotFoundException;
import org.example.model.Student;
import org.example.model.sequenser.StudentSequencer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDaoImpl implements StudentDao {

    List<Student> students;

    public StudentDaoImpl() {
        students = new ArrayList<>();
    }

    @Override
    public Optional<Student> find(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }

    @Override
    public Student save(Student student) throws IllegalArgumentException {
        if (student == null) throw new IllegalArgumentException("student was null");
        students.add(student);
        return student;

    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void delete(int id) throws ObjectNotFoundException {
        Optional<Student> s = find(id);
        if (!s.isPresent()) throw new ObjectNotFoundException("Object not found ", "student");
        students.remove(s.get());
    }

    @Override
    public void clear() {
        students.clear();
        StudentSequencer.reset();
    }
}
