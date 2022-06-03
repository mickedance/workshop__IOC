package org.example;

import org.example.config.ComponentAndBeanConfig;
import org.example.dao.impl.StudentDaoImpl;
import org.example.util.impl.UserScannerInput;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentAndBeanConfig.class);

        StudentDaoImpl studentService = context.getBean(StudentDaoImpl.class);
        UserScannerInput inputService = context.getBean(UserScannerInput.class);

        System.out.println(studentService.findAll());

        System.out.println("int:");
        System.out.println(inputService.getInt());
    }
}
