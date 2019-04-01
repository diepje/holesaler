package sr.unasat.holesaler.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String role;

    @Column
    private String username;

    @Column
    private String password;

    @JsonManagedReference(value = "employee")
    @OneToMany(targetEntity = RegistrationStatus.class, mappedBy = "employee")
    private List<RegistrationStatus> registrationStatusList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RegistrationStatus> getRegistrationStatusList() {
        return registrationStatusList;
    }

    public void setRegistrationStatusList(List<RegistrationStatus> registrationStatusList) {
        this.registrationStatusList = registrationStatusList;
    }


}
