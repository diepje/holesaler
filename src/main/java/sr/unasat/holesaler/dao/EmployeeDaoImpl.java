package sr.unasat.holesaler.dao;

import sr.unasat.holesaler.config.JPAConfiguration;
import sr.unasat.holesaler.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager = JPAConfiguration.getEntityManager();

    private static EmployeeDaoImpl employeeDao;

    private EmployeeDaoImpl() {
    }

    public static EmployeeDaoImpl getInstance() {
        if (employeeDao == null) {
            employeeDao = new EmployeeDaoImpl();
        }
        return employeeDao;
    }

    @Override
    public Employee getEmplopyeeByUsername(String username) {
        entityManager.getTransaction().begin();
        String jpql = "select e from Employee e where e.username = :username";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        query.setParameter("username", username);
        Employee employee = null;
        try {
            employee = query.getSingleResult();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return null;
        }
        entityManager.getTransaction().commit();
        return employee;
    }

}
