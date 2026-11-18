package sallergy.dev;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sallergy.dev.service.StudentService;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("sallergy.dev");
        StudentService studentService = annotationConfigApplicationContext.getBean(StudentService.class);

        Student student1 = new Student("David", 18);
        Student student2 = new Student("Dima", 22);

        studentService.saveStudent(student1);
        studentService.saveStudent(student2);


    }
}