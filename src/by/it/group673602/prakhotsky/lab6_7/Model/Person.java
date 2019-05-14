package Application.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "person", schema = "pisl_labs")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idperson;

    @NotBlank
    @Column(name = "surname")
    @Size(min=1, max = 50)
    private String surname;

    @NotBlank
    @Column(name = "name")
    @Size(min=1, max = 50)
    private String name;

    @NotBlank
    @Column(name = "patronym")
    @Size(min=1, max = 50)
    private String patronym;

    @Column(name = "date")
    private LocalDate date;

    @NotBlank
    @Column(name = "s_pasport")
    @Size(min=2, max = 2)
    private String s_pasport;

    @NotBlank
    @Column(name = "n_pasport")
    @Size(min=7, max = 7)
    private String n_pasport;

    @NotBlank
    @Column(name = "city")
    @Size(min=1, max = 50)
    private String city;

    @NotBlank
    @Column(name = "address")
    @Size(min=3, max = 50)
    private String address;

    @Column(name = "tel")
    @Size(min=11, max = 13)
    private String tel;

    @Email
    @Size(max = 50)
    @Column(name = "email")
    private String email;

    @Column(name = "is_job")
    private Boolean isJob;

    @Column(name = "post")
    @Size(min=1, max = 50)
    private String post;

    @NotBlank
    @Column(name = "city_registration")
    @Size(min=1, max = 50)
    private String city_registration;

    @NotBlank
    @Column(name = "citizenship")
    @Size(min=1, max = 50)
    private String citizenship;

    public Long getIdperson() {
        return idperson;
    }

    public void setIdperson(Long idperson) {
        this.idperson = idperson;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getJob() {
        return isJob;
    }

    public void setJob(Boolean job) {
        isJob = job;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getS_pasport() {
        return s_pasport;
    }

    public void setS_pasport(String s_pasport) {
        this.s_pasport = s_pasport;
    }

    public String getN_pasport() {
        return n_pasport;
    }

    public void setN_pasport(String n_pasport) {
        this.n_pasport = n_pasport;
    }

    public String getCity_registration() {
        return city_registration;
    }

    public void setCity_registration(String city_registration) {
        this.city_registration = city_registration;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void init(Person person){

        this.setSurname(person.getSurname());
        this.setName(person.getName());
        this.setPatronym(person.getPatronym());
        this.setS_pasport(person.getS_pasport());
        this.setN_pasport(person.getN_pasport());
        this.setDate(person.getDate());
        this.setAddress(person.getAddress());
        this.setCitizenship(person.getCitizenship());
        this.setCity(person.getCity());
        this.setCity_registration(person.getCity_registration());
        this.setEmail(person.getEmail());
        this.setJob(person.getJob());
        this.setPost(person.getPost());
        this.setTel(person.getTel());

    }
}
