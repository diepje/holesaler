package sr.unasat.holesaler.dao;

import sr.unasat.holesaler.config.JPAConfiguration;
import sr.unasat.holesaler.entity.Company;
import sr.unasat.holesaler.entity.RegistrationStatus;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CompanyDaoImpl implements CompanyDao {

    private EntityManager entityManager = JPAConfiguration.getEntityManager();

    private static CompanyDao companyDao;

    private CompanyDaoImpl() {
    }

    public static CompanyDao getInstance() {
        if (companyDao == null) {
            companyDao = new CompanyDaoImpl();
        }
        return companyDao;
    }

    @Override
    public Company getCompanyByName(String name) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Company c where c.name = :name";
        TypedQuery<Company> query = entityManager.createQuery(jpql, Company.class);
        query.setParameter("name", name);
        Company company = query.getSingleResult();
        entityManager.getTransaction().commit();
        return company;
    }

    @Override
    public List<Company> getAllCompanies() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Company c";
        TypedQuery<Company> query = entityManager.createQuery(jpql, Company.class);
        List<Company> companyList = query.getResultList();
        entityManager.getTransaction().commit();
        return companyList;
    }

    @Override
    public void addCompany(Company company) {
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeCompany(Long id) {
        entityManager.getTransaction().begin();
        Company company = entityManager.find(Company.class, id);
        entityManager.remove(company);
        entityManager.getTransaction().commit();
    }

    @Override
    public Company getCompanyByUsername(String username) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Company c where username = :username";
        TypedQuery<Company> query = entityManager.createQuery(jpql, Company.class);
        query.setParameter("username", username);
        Company company;
        try {
            company = query.getSingleResult();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return null;
        }
        entityManager.getTransaction().commit();
        return company;
    }

    @Override
    public List<Company> getAllNewCompanyRegistrations() {
        String status = "NEW";
        entityManager.getTransaction().begin();
        String jpql = "select c from Company c where c.registrationStatus.status = :status";
        TypedQuery<Company> query = entityManager.createQuery(jpql, Company.class);
        query.setParameter("status", status);
        List<Company> newCompanies = query.getResultList();
        return newCompanies;
    }

    @Override
    public void approveCompanyRegistration(Long id) {
        String status = "APPROVED";
        entityManager.getTransaction().begin();
        String jpql = "update RegistrationStatus rs set rs.status = :status where rs.company.id = :id";
        TypedQuery<RegistrationStatus> query = entityManager.createQuery(jpql, RegistrationStatus.class);
        query.setParameter("status", status);
        query.setParameter("id", id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
