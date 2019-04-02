package sr.unasat.holesaler.designPatterns.state;

import sr.unasat.holesaler.dto.CompanyDto;

public class EmployeeState implements Strategy{

    @Override
    public CompanyDto getCompanyDto(CompanyDto companyDto){
        companyDto.setStrategy("Employee");
        return companyDto;
    }
}
