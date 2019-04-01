package sr.unasat.holesaler.dao;


import sr.unasat.holesaler.config.JPAConfiguration;
import sr.unasat.holesaler.entity.RegistrationStatus;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class RegistrationStatusDaoImpl implements RegistrationStatusDao {

    private EntityManager entityManager = JPAConfiguration.getEntityManager();

    private static RegistrationStatusDaoImpl registrationStatusDao;

    private RegistrationStatusDaoImpl() {
    }

    public static RegistrationStatusDaoImpl getInstance() {
        if (registrationStatusDao == null) {
            registrationStatusDao = new RegistrationStatusDaoImpl();
        }
        return registrationStatusDao;
    }

    @Override
    public RegistrationStatus getCompanyRegistrationStatus(Long companyId) {
        entityManager.getTransaction().begin();
        String jpql = "select rs from RegistrationStatus rs where rs.company.id = :companyId";
        TypedQuery<RegistrationStatus> query = entityManager.createQuery(jpql, RegistrationStatus.class);
        query.setParameter("companyId", companyId);
        RegistrationStatus registrationStatus;
        try {
            registrationStatus = query.getSingleResult();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return null;
        }
        entityManager.getTransaction().commit();
        return registrationStatus;
    }

    @Override
    public void updateCompanyRegistrationStatus(RegistrationStatus registrationStatus) {
        entityManager.getTransaction().begin();
        entityManager.merge(registrationStatus);
        entityManager.getTransaction().commit();
    }
}
