package by.it.group673602.prahotsky.lab5.Entity;

import Addition.Citizenship;
import Addition.Passport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Person",propOrder = {
        "lastName",
        "firstName",
        "thirdName",
        "birthDate",
        "passport",
        "citizenship",
        "job",
        "post",
        "actualCity",
        "actualAddress",
})
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
public class Person implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @XmlElement(required = true)
    private String lastName;
    @XmlElement(required = true)
    private String firstName;
    @XmlElement(required = true)
    private String thirdName;
    @XmlElement(required = true)
    private Passport passport;
    @XmlElement(required = true)
    private Date birthDate;
    @XmlElement(required = true)
    private String actualCity;
    @XmlElement(required = true)
    private String actualAddress;
    @XmlElement(required = true)
    @Enumerated(EnumType.STRING)
    private Citizenship citizenship;
    @XmlElement(required = true)
    private Boolean job;
    @XmlElement(required = true)
    private String post;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getActualCity() {
        return actualCity;
    }

    public void setActualCity(String actualCity) {
        this.actualCity = actualCity;
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public void setActualAddress(String actualAddress) {
        this.actualAddress = actualAddress;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    public Boolean isJob() {
        return job;
    }

    public void setJob(Boolean job) {
        this.job = job;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
