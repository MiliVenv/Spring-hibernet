package sallergy.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sallergy.dev.service.CourseService;
import sallergy.dev.service.GroupService;
import sallergy.dev.service.ProfileService;
import sallergy.dev.service.StudentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("sallergy.dev");
        SessionFactory sessionFactory = annotationConfigApplicationContext.getBean(SessionFactory.class);
        StudentService studentService = annotationConfigApplicationContext.getBean(StudentService.class);
        ProfileService profileService = annotationConfigApplicationContext.getBean(ProfileService.class);
        GroupService groupService = annotationConfigApplicationContext.getBean(GroupService.class);
        CourseService courseService = annotationConfigApplicationContext.getBean(CourseService.class);
//
//        Group group1 = new Group("abc1", 2026L);
//        Group group2 = new Group("abc2", 2027L);
//        Group group3 = new Group("abc3", 1234L);
//
//        groupService.saveGroup(group1);
//        groupService.saveGroup(group2);
//        groupService.saveGroup(group3);
//
//        Student student1 = new Student("David", 18, group1);
//        Student student2 = new Student("Dima", 22, group2);
//
//        studentService.saveStudent(student1);
//        studentService.saveStudent(student2);
//
//        Profile profile1 = new Profile("My bio", LocalDateTime.now(), student1);
//
//        System.out.println(profileService.saveProfile(profile1).toString());
//
//        var session = sessionFactory.openSession();
//
//        group1 = session.find(Group.class, 1);
//
//        List<Student> students = group1.getStudentList();
//
//        System.out.println(group1.toString());
//
//        session.close();
//
////        List<Student> students = group1.getStudentList();
//
//        for (Student student : students) {
//            System.out.println(student.toString());
//        }
//
//        List<Group> groups = groupService.getAllGroup();
//
//        Course course1 = new Course("math-1", "math");
//        Course course2 = new Course("math-2", "math");
//        Course course3 = new Course("math-3", "math");
//
//        courseService.saveCourse(course1);
//        courseService.saveCourse(course2);
//        courseService.saveCourse(course3);

        courseService.enrollStudentToCourse(2L, 2L);
        courseService.enrollStudentToCourse(3L, 2L);

        Student student = studentService.getById(2L);
        System.out.println(student.toString());
    }
}
