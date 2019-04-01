package sr.unasat.holesaler.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "registration_status")
public class RegistrationStatus {

    public RegistrationStatus() {
    }

    public RegistrationStatus(String status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne()
    @JsonBackReference(value = "company-registration")
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JsonBackReference(value = "employee")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column
    String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
