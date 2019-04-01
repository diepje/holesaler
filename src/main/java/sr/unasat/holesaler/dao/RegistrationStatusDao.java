package sr.unasat.holesaler.dao;

import sr.unasat.holesaler.entity.RegistrationStatus;

public interface RegistrationStatusDao {

    RegistrationStatus getCompanyRegistrationStatus(Long companyId);

    void approveCompanyRegistration(RegistrationStatus registrationStatus);
}
