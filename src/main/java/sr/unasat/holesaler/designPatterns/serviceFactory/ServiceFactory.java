package sr.unasat.holesaler.designPatterns.serviceFactory;

import sr.unasat.holesaler.service.AuthService;

public class ServiceFactory {

    private static Service authService = new AuthService();
    private static Service companyService;
    private static Service employeeService;

    public static Service getInstance(String service) {
        switch (service) {
            case "AUTHENTICATION":
                return authService;
            case "CompanyService":
                return companyService;
            case "EmployeeService":
                return employeeService;
        }
        return null;
    }

}
