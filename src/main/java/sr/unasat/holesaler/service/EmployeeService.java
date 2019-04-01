package sr.unasat.holesaler.service;

import sr.unasat.holesaler.dao.EmployeeDao;
import sr.unasat.holesaler.dao.EmployeeDaoImpl;
import sr.unasat.holesaler.entity.Employee;

public class EmployeeService {

    private EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();

    private EmployeeService(){

    }

    private static EmployeeService employeeService;

    public static EmployeeService getInstance(){
        if(employeeService == null){
            employeeService = new EmployeeService();
        }
        return employeeService;
    }

    public Employee getEmployeeByUsername(String username){
        return employeeDao.getEmplopyeeByUsername(username);
    }
}
