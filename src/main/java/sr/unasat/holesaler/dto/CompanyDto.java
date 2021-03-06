package sr.unasat.holesaler.dto;

import sr.unasat.holesaler.entity.PhoneNumber;
import sr.unasat.holesaler.entity.RegistrationStatus;

import java.util.List;

public class CompanyDto {

    private Long id;

    private String name;

    private String address;

    private List<PhoneNumber> phoneNumber;

    private String email;

    private String kkfRegistration;

    private boolean retail;

    private boolean wholesale;

    private RegistrationStatus registrationStatus;

    public RegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(RegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<PhoneNumber> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKkfRegistration() {
        return kkfRegistration;
    }

    public void setKkfRegistration(String kkfRegistration) {
        this.kkfRegistration = kkfRegistration;
    }

    public boolean isRetail() {
        return retail;
    }

    public void setRetail(boolean retail) {
        this.retail = retail;
    }

    public boolean isWholesale() {
        return wholesale;
    }

    public void setWholesale(boolean wholesale) {
        this.wholesale = wholesale;
    }
}
