package sr.unasat.holesaler.service;

import sr.unasat.holesaler.config.JPAConfiguration;
import sr.unasat.holesaler.dao.RegistrationStatusDao;
import sr.unasat.holesaler.dao.RegistrationStatusDaoImpl;
import sr.unasat.holesaler.entity.RegistrationStatus;

public class StatusService {

    private RegistrationStatusDao registrationStatusDao = RegistrationStatusDaoImpl.getInstance();

    private static StatusService statusService;

    private StatusService() {
    }

    public static StatusService getInstance() {
        if (statusService == null) {
            statusService = new StatusService();
        }
        return statusService;
    }

    public boolean approveCompanyRegistration(Long companyId) {
        RegistrationStatus companyRegistrationStatus;
        try {
            companyRegistrationStatus = registrationStatusDao.getCompanyRegistrationStatus(companyId);
            companyRegistrationStatus.setStatus("APPROVED");
            registrationStatusDao.approveCompanyRegistration(companyRegistrationStatus);
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return false;
        }
        return companyRegistrationStatus.getId() == null;
    }
}
