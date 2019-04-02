package sr.unasat.holesaler.designPatterns.state;

import sr.unasat.holesaler.dto.CompanyDto;

public class AdminState implements Strategy{

    @Override
    public CompanyDto getCompanyDto(CompanyDto companyDto){
        companyDto.setStrategy("Admin");
        return companyDto;
    }
}
