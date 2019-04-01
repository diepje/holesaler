package sr.unasat.holesaler.service;

import sr.unasat.holesaler.dao.CompanyDao;
import sr.unasat.holesaler.dao.CompanyDaoImpl;
import sr.unasat.holesaler.dao.EmployeeDao;
import sr.unasat.holesaler.dao.EmployeeDaoImpl;
import sr.unasat.holesaler.entity.Company;
import sr.unasat.holesaler.entity.Employee;

import javax.ws.rs.core.Response;

public class AuthService {

    CompanyDao companyDao = CompanyDaoImpl.getInstance();
    EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();

//    public boolean login (String username, String password){
//        Company company = companyDao.getCompanyByUsername(username.toLowerCase());
//        Employee employee = employeeDao.getEmplopyeeByUsername(username.toLowerCase());
//        if (company != null){
//            return company.getPassword().equals(password) ?
//                    Response.ok().build() :
//                    Response.status(Response.Status.UNAUTHORIZED).build();
//        }
//    }
}
