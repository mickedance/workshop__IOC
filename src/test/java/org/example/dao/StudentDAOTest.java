package org.example.dao;

import org.example.config.ComponentAndBeanConfig;
import org.example.dao.impl.StudentDaoImpl;
import org.example.exception.ObjectNotFoundException;
import org.example.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentAndBeanConfig.class)
public class StudentDAOTest {

    @Autowired
    StudentDaoImpl studentDao;

    @Test
    public void test_save_should_return_same_object_params() {
        studentDao.clear();
        Student expected = new Student("Mikael", 1);
        Student actual = studentDao.save(new Student("Mikael"));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_save_should_throw_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> studentDao.save(null));
    }

    @Test
    public void test_find_should_return_expected_object() {
        studentDao.clear();
        Student expected = new Student("Mikael", 1);
        studentDao.save(expected);
        Optional<Student> result = studentDao.find(expected.getId());
        Student actual = result.isPresent() ? result.get() : null;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_find_should_return_false() {
        studentDao.clear();
        studentDao.save(new Student("Anna", 2));
        Optional<Student> actual = studentDao.find(1);
        Assertions.assertFalse(actual.isPresent());
    }

    @Test
    public void test_findAll_return_2_in_length() {
        studentDao.clear();
        studentDao.save(new Student("Kia"));
        studentDao.save(new Student("John"));
        Assertions.assertEquals(2, studentDao.findAll().size());
    }

    @Test
    public void test_delete_should_remove_1_item() {
        studentDao.clear();
        studentDao.save(new Student("Beata", 2));
        try {
            studentDao.delete(2);
            Assertions.assertEquals(0, studentDao.findAll().size());
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_delete_should_throw_exception() {
        studentDao.clear();
        studentDao.save(new Student("Johnny", 3));
        Assertions.assertThrows(ObjectNotFoundException.class, () -> studentDao.delete(1));
    }

    @Test
    public void test_clear_should_return_0_in_length() {
        studentDao.save(new Student("Anna"));
        studentDao.save(new Student("Brittmarie"));
        studentDao.clear();
        Assertions.assertEquals(0, studentDao.findAll().size());
    }
}
