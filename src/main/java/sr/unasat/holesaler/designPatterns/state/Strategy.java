package sr.unasat.holesaler.designPatterns.state;

import sr.unasat.holesaler.dto.CompanyDto;

public interface Strategy {
    CompanyDto getCompanyDto(CompanyDto companyDto);
}
