package sallergy.dev.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import sallergy.dev.Student;
import sallergy.dev.TransactionHelper;

import java.util.List;

@Service
public class StudentService {

    private SessionFactory sessionFactory;
    private final TransactionHelper transactionHelpert;

    public StudentService(SessionFactory sessionFactory, TransactionHelper transactionHelpert) {
        this.sessionFactory = sessionFactory;
        this.transactionHelpert = transactionHelpert;
    }

    public Student saveStudent(Student student) {
        return transactionHelpert.executeInTransactionReturn(session -> {
            session.persist(student);
            return student;
        });
    }

    public void deleteStudent(Long id) {
        transactionHelpert.executeInTransaction(session -> {
            Student studentForDelete = session.find(Student.class, id);
            session.remove(studentForDelete);
        });
    }

    public Student updateStudent(Student student) {
        return transactionHelpert.executeInTransactionReturn(session -> {
            session.merge(student);
            return student;
        });
    }

    public Student getById(Long id) {
        try (Session session = sessionFactory.openSession();) {
            return session.find(Student.class, id);
        }
    }

    public List<Student> findAll(){
        try (Session session = sessionFactory.openSession();) {
            return session.createQuery("SELECT s FROM Student s", Student.class).list();
        }
    }

}
