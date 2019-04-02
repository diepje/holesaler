package sr.unasat.holesaler.service;

import sr.unasat.holesaler.dao.CompanyDao;
import sr.unasat.holesaler.dao.CompanyDaoImpl;
import sr.unasat.holesaler.entity.Company;
import sr.unasat.holesaler.entity.PhoneNumber;
import sr.unasat.holesaler.entity.RegistrationStatus;

import java.util.List;

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
        company.getRegistrationStatus().setCompany(company);
        for(PhoneNumber phoneNumber : company.getPhoneNumber()){
            phoneNumber.setCompany(company);
        }
        companyDao.addCompany(company);
    }

    public List<Company> getAllActiveCompanies(){
        return companyDao.getCompaniesByStatus("APPROVED");
    }

    public List<Company> getAllNewRequests(){
        return companyDao.getCompaniesByStatus("NEW");
    }

    public List<Company> getAllCompanies(){
        return companyDao.getAllCompanies();
    }

    public Company getCompanyByName(String name){
        return companyDao.getCompanyByName(name);
    }

    public void removeCompany(Long id){
        companyDao.removeCompany(id);
    }

    public Company getCompanyByUsername(String username){
        return companyDao.getCompanyByUsername(username);
    }

}
