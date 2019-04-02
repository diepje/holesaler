package sr.unasat.holesaler.designPatterns.state;

import sr.unasat.holesaler.dto.CompanyDto;

public class EmployeeState implements State {

    @Override
    public CompanyDto getCompanyDto(CompanyDto companyDto){
        companyDto.setRegistrationStatus(null);
        return companyDto;
    }
}
