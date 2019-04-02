package sr.unasat.holesaler.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import sr.unasat.holesaler.dao.CompanyDao;

import javax.persistence.*;

@Entity
@Table(name = "phone_number")
public class PhoneNumber {

    public PhoneNumber() {
    }

    public PhoneNumber(Company company) {
        this.company = company;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "company_id")
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
