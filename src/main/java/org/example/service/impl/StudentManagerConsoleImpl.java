package org.example.service.impl;

import org.example.dao.StudentDao;
import org.example.exception.ObjectNotFoundException;
import org.example.model.Student;
import org.example.service.StudentManager;
import org.example.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentManagerConsoleImpl implements StudentManager {

    private final StudentDao studentDao;
    private final UserInput userInput;

    @Autowired
    public StudentManagerConsoleImpl(StudentDao studentDao, UserInput userInput) {
        this.studentDao = studentDao;
        this.userInput = userInput;
    }

    @Override
    public Student createAndSave() {
        System.out.println("### CREATE STUDENT ####");
        System.out.println("Name: ");
        String name = userInput.getString();
        Student student = new Student(name);
        return save(student);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);

    }

    @Override
    public Optional<Student> find(int id) {
        return studentDao.find(id);
    }

    @Override
    public void remove(int id) throws ObjectNotFoundException {
        studentDao.delete(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        String newName = "a new name";
        student.setName(newName);
        return student;
    }

    @Override
    public void clear() {
        studentDao.clear();
    }
}
