package sr.unasat.holesaler.designPatterns.state;

import sr.unasat.holesaler.dto.CompanyDto;

public class NonEmployeeState implements State {

    @Override
    public CompanyDto getCompanyDto(CompanyDto companyDto){
        return null;
    }
}
