package sit.int202.classicmodels.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import sit.int202.classicmodels.utils.EntityManagerBuilder;

import java.util.List;

@NoArgsConstructor
public class OfficeRepository {

    private EntityManager em;

    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = EntityManagerBuilder.getEntityManager();
        }
        return em;
    }
    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("Office.findAll").getResultList();
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public void deleteByCode(String officeCode) {
        EntityManager em = getEntityManager();
        Office office = em.find(Office.class, officeCode);
        em.getTransaction().begin();
        em.remove(office);
        em.flush();
        em.getTransaction().commit();
    }
}
