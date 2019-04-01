package sr.unasat.holesaler.dao;

import sr.unasat.holesaler.entity.RegistrationStatus;

public interface RegistrationStatusDao {

    RegistrationStatus getCompanyRegistrationStatus(Long companyId);

    void updateCompanyRegistrationStatus(RegistrationStatus registrationStatus);
}
