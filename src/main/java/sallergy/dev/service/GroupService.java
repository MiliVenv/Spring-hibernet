package sallergy.dev.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import sallergy.dev.Group;
import sallergy.dev.TransactionHelper;

import java.util.List;

@Service
public class GroupService {
    private final SessionFactory sessionFactory;
    private final TransactionHelper transactionHelper;

    public GroupService(SessionFactory sessionFactory, TransactionHelper transactionHelper) {
        this.sessionFactory = sessionFactory;
        this.transactionHelper = transactionHelper;
    }

    public Group saveGroup(Group group) {
        return transactionHelper.executeInTransactionReturn(session -> {
            session.persist(group);
            return group;
        });
    }

    public List<Group> getAllGroup() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT g FROM Group g left join fetch g.studentList s left join fetch s.profile"
                    , Group.class)
                    .list();
        }
    }
}
