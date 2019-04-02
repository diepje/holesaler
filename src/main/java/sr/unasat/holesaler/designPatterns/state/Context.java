package sr.unasat.holesaler.designPatterns.state;

import sr.unasat.holesaler.dto.CompanyDto;

public class Context {

    private Strategy strategy;

    public void setStrategy(String role) {
        if (role == "ADMIN") {
            this.strategy = new AdminState();
        }
        if (role == "EMPLOYEE"){
            this.strategy = new EmployeeState();
        }
    }

    public CompanyDto getCompanyDto(CompanyDto companyDto) {
        return strategy.getCompanyDto(companyDto);
    }
}
