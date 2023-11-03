package sit.int202.classicmodels.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerBuilder {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
