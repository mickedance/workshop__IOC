package org.example;

import org.example.config.ComponentAndBeanConfig;
import org.example.dao.impl.StudentDaoImpl;
import org.example.model.Student;
import org.example.service.impl.StudentManagerConsoleImpl;
import org.example.util.impl.UserScannerInput;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentAndBeanConfig.class);

        // StudentDaoImpl studentService = context.getBean(StudentDaoImpl.class);
        //UserScannerInput inputService = context.getBean(UserScannerInput.class);
        StudentManagerConsoleImpl studentManager = context.getBean(StudentManagerConsoleImpl.class);



    }
}
