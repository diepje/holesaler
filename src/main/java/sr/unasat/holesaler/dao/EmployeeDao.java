package sr.unasat.holesaler.dao;

import sr.unasat.holesaler.entity.Employee;

public interface EmployeeDao {
    Employee getEmplopyeeByUsername(String username);
}
