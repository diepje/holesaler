package sr.unasat.holesaler.service;

import sr.unasat.holesaler.designPatterns.serviceFactory.Service;
import sr.unasat.holesaler.entity.Company;
import sr.unasat.holesaler.entity.Credentials;
import sr.unasat.holesaler.entity.Employee;

public class AuthService implements Service {

    private static AuthService authService = new AuthService();

    @Override
    public Service getInstance() {
        return authService;
    }


    //    private AuthService() {
//    }
//
//    public static AuthService getInstance(){
//        if (authService == null){
//            authService = new AuthService();
//        }
//        return authService;
//    }

    public boolean login(Employee employee, Credentials credentials){
        return employee.getUsername().toLowerCase().equals(credentials.getUsername().toLowerCase()) && employee.getPassword().equals(credentials.getPassword());
    }

    public boolean login(Company company, Credentials credentials){
        return company.getUsername().toLowerCase().equals(credentials.getUsername().toLowerCase()) && company.getPassword().equals(credentials.getPassword());
    }

}
