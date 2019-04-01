package sr.unasat.holesaler.dao;

import sr.unasat.holesaler.entity.Company;

import java.util.List;

public interface CompanyDao {

    Company getCompanyByName(String name);

    List<Company> getAllCompanies();

    void addCompany(Company company);

    void removeCompany(Long id);

    Company getCompanyByUsername(String username);

    List<Company> getAllNewCompanyRegistrations();

    void approveCompanyRegistration(Long id);
}
