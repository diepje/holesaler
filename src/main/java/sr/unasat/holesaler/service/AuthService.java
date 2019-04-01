package sr.unasat.holesaler.service;


import sr.unasat.holesaler.entity.Company;
import sr.unasat.holesaler.entity.Credentials;
import sr.unasat.holesaler.entity.Employee;

import javax.swing.undo.CannotRedoException;

public class AuthService {

    private static AuthService authService;

    private AuthService() {
    }

    public static AuthService getInstance(){
        if (authService == null){
            authService = new AuthService();
        }
        return authService;
    }

    public boolean login(Employee employee, Credentials credentials){
        return employee.getUsername().toLowerCase().equals(credentials.getUsername().toLowerCase()) && employee.getPassword().equals(credentials.getPassword());
    }

    public boolean login(Company company, Credentials credentials){
        return company.getUsername().toLowerCase().equals(credentials.getUsername().toLowerCase()) && company.getPassword().equals(credentials.getPassword());
    }

}
