package org.example.model.sequenser;

import org.example.config.ComponentAndBeanConfig;
import org.example.model.sequenser.StudentSequencer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentAndBeanConfig.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentSequencerTest {
    @Test
    @Order(1)
    public void next_id_should_be_1() {
        Assertions.assertEquals(1, StudentSequencer.getNext());

    }

    @Test
    @Order(2)
    public void reset_id_to_zero() {
        StudentSequencer.reset();
        Assertions.assertEquals(0, StudentSequencer.getCurrent());
    }
}
