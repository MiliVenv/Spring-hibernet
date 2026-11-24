package sallergy.dev.service;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import sallergy.dev.Profile;
import sallergy.dev.TransactionHelper;

@Service
public class ProfileService {
    private final SessionFactory sessionFactory;
    private final TransactionHelper transactionHelpert;

    public ProfileService(SessionFactory sessionFactory, TransactionHelper transactionHelpert) {
        this.sessionFactory = sessionFactory;
        this.transactionHelpert = transactionHelpert;
    }

    public Profile saveProfile(Profile profile) {
        return transactionHelpert.executeInTransactionReturn(session -> {
            session.persist(profile);
            return profile;
        });
    }
}
