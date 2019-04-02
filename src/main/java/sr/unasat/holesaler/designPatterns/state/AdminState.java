package sr.unasat.holesaler.designPatterns.state;

import sr.unasat.holesaler.dto.CompanyDto;

public class AdminState implements State {

    @Override
    public CompanyDto getCompanyDto(CompanyDto companyDto){
        return companyDto;
    }
}
