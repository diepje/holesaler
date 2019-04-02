package sr.unasat.holesaler.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company extends Credentials implements Serializable {

    public Company() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @JsonManagedReference
    @OneToMany(targetEntity = PhoneNumber.class, mappedBy = "company", orphanRemoval = true, cascade = CascadeType.PERSIST)
//    @MapKey(name="id")
    private List<PhoneNumber> phoneNumber = new ArrayList<>();

    @Column
    private String email;

    @Column(name = "kkf_registration")
    private String kkfRegistration;

    @Column
    private boolean retail;

    @Column
    private boolean wholesale;

    @Column
    private String username;

    @Column
    private String password;

    @JsonManagedReference(value = "company")
    @OneToOne(targetEntity = RegistrationStatus.class, mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL)
    private RegistrationStatus registrationStatus;

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

    public RegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(RegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }
}
