package org.example.model;

import org.example.config.ComponentAndBeanConfig;
import org.example.model.sequenser.StudentSequencer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentAndBeanConfig.class)


public class StudentTest {

    @Test
    public void constructor_should_throw_error_param1_is_null() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student(null, 1)
        );
    }

    @Test
    public void constructor_should_throw_error_param1_is_empty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("", 1)
        );
    }

    @Test
    public void constructor_should_throw_error_param1_is_empty_only_1_param_sent() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student(""));
    }

    @Test
    public void should_return_next_id() {
        int expected = StudentSequencer.getCurrent() + 1;
        Assertions.assertEquals(expected, new Student("goran").getId());
    }

    @Test
    public void should_return_new_id() {
        int expected = 450;
        Student s = new Student("Horatio", 2);
        s.setId(expected);
        Assertions.assertEquals(expected, s.getId());
    }

    @Test
    public void should_return_new_name() {
        String expected = "Karro";
        Student s = new Student("hellio");
        s.setName(expected);
        Assertions.assertEquals(expected, s.getName());
    }

    @Test
    public void should_be_equal() {
        Student s1 = new Student("Mikael", 1);
        Student s2 = new Student("Mikael", 1);

        Assertions.assertEquals(s1, s2);
    }
}
