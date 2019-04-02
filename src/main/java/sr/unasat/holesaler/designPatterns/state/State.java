package sr.unasat.holesaler.designPatterns.state;

import sr.unasat.holesaler.dto.CompanyDto;

public interface State {
    CompanyDto getCompanyDto(CompanyDto companyDto);
}
