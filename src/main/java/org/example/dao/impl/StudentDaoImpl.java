package org.example.dao.impl;

import org.example.dao.StudentDao;
import org.example.model.Student;
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
    public Student find(int id) {
        Optional<Student> student = students.stream().filter(s -> s.getId() == id).findFirst();
        return student.isPresent() ? student.get(): null;
    }

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("student was null");
        students.add(student);
        return student;

    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void delete(int id) {
        Student s = find(id);
        if(s==null) return;
        students.remove(s);
    }
}
