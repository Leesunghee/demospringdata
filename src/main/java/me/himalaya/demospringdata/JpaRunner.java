package me.himalaya.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account   = new Account();
        account.setUsername("realwunz");
        account.setPassword("hibernate");

        Session session = entityManager.unwrap(Session.class);

//        entityManager.persist(account);

        session.save(account);
    }
}
