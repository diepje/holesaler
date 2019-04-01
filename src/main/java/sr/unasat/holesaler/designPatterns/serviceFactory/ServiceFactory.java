package sr.unasat.holesaler.designPatterns.serviceFactory;

import sr.unasat.holesaler.service.AuthService;

public class ServiceFactory {

    private Service authService = new AuthService();
    private Service companyService;
    private Service employeeService;

    public Service getInstance(String service) {
        switch (service) {
            case "AuthService":
                return authService;
            case "CompanyService":
                return companyService;
            case "EmployeeService":
                return employeeService;
        }
        return null;
    }

}
