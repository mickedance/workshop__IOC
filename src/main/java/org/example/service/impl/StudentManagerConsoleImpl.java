package org.example.service.impl;

import org.example.dao.StudentDao;
import org.example.model.Student;
import org.example.service.StudentManager;
import org.example.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public Student find() {
        System.out.println("### Find student  by id ###");
        int id = userInput.getInt();
        return  studentDao.find(id);
    }

    @Override
    public void remove() {
        System.out.println("### Choose id to remove ###");
        System.out.println(findAll());
        System.out.println("Type id:");
        int id = userInput.getInt();
        studentDao.delete(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        System.out.println("### Edit student ###");
        System.out.println("Change name from: "+ student.getName());
        System.out.println("Type new name: ");
        String newName =userInput.getString();
        student.setName(newName);
        return student;
    }
}
