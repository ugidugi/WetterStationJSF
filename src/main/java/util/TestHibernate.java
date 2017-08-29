
package util;

import org.hibernate.SessionFactory;


public class TestHibernate {
     private final SessionFactory sessionFactory;

    public TestHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
     
     
}
