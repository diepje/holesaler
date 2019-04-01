package sr.unasat.holesaler.service;

import sr.unasat.holesaler.dao.CompanyDao;
import sr.unasat.holesaler.dao.CompanyDaoImpl;
import sr.unasat.holesaler.entity.Company;
import sr.unasat.holesaler.entity.RegistrationStatus;

public class CompanyService {

    private CompanyDao companyDao = CompanyDaoImpl.getInstance();

    private static CompanyService companyService;

    private CompanyService() {

    }

    public static CompanyService getInstance() {
        if (companyService == null) {
            companyService = new CompanyService();
        }
        return companyService;
    }

    public void registerNewCompany(Company company) {
        company.setRegistrationStatus(new RegistrationStatus("NEW"));
        companyDao.addCompany(company);
    }

}
