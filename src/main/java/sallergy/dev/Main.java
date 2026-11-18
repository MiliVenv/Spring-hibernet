package sallergy.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("sallergy.dev");

        SessionFactory sessionFactory = annotationConfigApplicationContext.getBean(SessionFactory.class);
        Session session = sessionFactory.openSession();

        Student student1 = new Student("Vasya", 22);
        Student student2 = new Student("Petya", 19);
//        Student student3 = new Student("null", 12);
        session.beginTransaction();
        session.persist(student1);
        session.persist(student2);
//        session.persist(student3);
        session.getTransaction().commit();

        Student studentby1 = session.find(Student.class, 1L);
        System.out.println(studentby1.toString());

        Student studentby2 = session.createQuery(
                "SELECT s from Student s where s.id = :id", Student.class).setParameter("id", 2L).getSingleResult();
        System.out.println(studentby2.toString());

        session.beginTransaction();

        Student studentForUpdate = session.find(Student.class, 1L);

        studentForUpdate.setAge(30);
        studentForUpdate.setName("Dima");

        session.getTransaction().commit();

        session.beginTransaction();

//        Student studentForDelete = session.find(Student.class, 2L);
//        session.remove(studentForDelete);
//
//        session.createQuery("DELETE FROM Student s where s.id = :id").setParameter("id", 2L).executeUpdate();

        session.createNativeQuery("delete from students s where s.id = 2").executeUpdate();

        session.getTransaction().commit();

        List<Student> students = session.createQuery("SELECT s FROM Student s", Student.class).list();
        for (Student student : students) {
            System.out.println(student.toString());
        }

        Student studentbyName = session.createQuery(
                "SELECT s from Student s where s.name = :name", Student.class).setParameter("name", "Dima").getSingleResult();
        System.out.println(studentbyName.toString());

        session.beginTransaction();

        Student student4 = new Student("Dima", 1);
        session.persist(student4);

        session.getTransaction().commit();

        session.close();
    }
}