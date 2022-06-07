package org.example.service;

import org.example.config.ComponentAndBeanConfig;
import org.example.exception.ObjectNotFoundException;
import org.example.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentAndBeanConfig.class)
public class StudentManagerTest {
    @Autowired
    private StudentManager studentManager;

    @Test
    public void save_return_equal_object() {
        Student expected = new Student("Anna", 99);
        Student actual = studentManager.save(expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void save_should_throw_Exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> studentManager.save(null));
    }

    @Test
    public void find_should_return_object_with_id_987_assert_true() {
        studentManager.clear();
        Student expected = new Student("micke", 987);
        studentManager.save(expected);
        Optional<Student> actual = studentManager.find(987);
        Assertions.assertTrue(actual.isPresent());
    }

    @Test
    public void find_should_return_empty_optional_assert_false() {
        studentManager.clear();
        Optional<Student> actual = studentManager.find(1);
        Assertions.assertFalse(actual.isPresent());
    }

    @Test
    public void delete_should_throw_exception() {
        studentManager.clear();
        Assertions.assertThrows(ObjectNotFoundException.class, () -> studentManager.remove(1));
    }

    @Test
    public void delete_object_list_should_be_1_in_length() {
        studentManager.clear();
        studentManager.save(new Student("anna", 10));
        studentManager.save(new Student("Jonna", 20));
        try {
            studentManager.remove(10);
            Assertions.assertEquals(1, studentManager.findAll().size());
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAll_should_return_equal_list() {
        studentManager.clear();
        Student s1 = new Student("Ikea1");
        Student s2 = new Student("Ikea2");
        Student s3 = new Student("Ikea3");
        studentManager.save(s1);
        studentManager.save(s2);
        studentManager.save(s3);
        List<Student> excpected = new ArrayList<>();
        excpected.add(s1);
        excpected.add(s2);
        excpected.add(s3);
        Assertions.assertEquals(excpected, studentManager.findAll());
    }

    @Test
    public void clear_should_empty_list() {
        studentManager.save(new Student("anna"));
        studentManager.clear();
        List<Student> studentList = studentManager.findAll();
        Assertions.assertTrue(studentList.isEmpty());
    }
}
