package main.java.com.solvd.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import main.java.com.solvd.database.services.Adapter.XmlDateAdapter;

import java.util.Date;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @JsonProperty
    @XmlAttribute(name="id")
    private int ID;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private int age;
    @JsonProperty
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    @XmlElement(name = "hireDate")
    private Date hd;
    @JsonProperty
    private ContactInformation contactInformation;
    @JsonProperty
    @XmlElementWrapper(name = "phones")
    @XmlElement(name = "phone")
    private List<Phone> phoneList;

    public User(){}

    public User(int ID, String firstName, String lastName, int age, Date hd) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hd = hd;
    }

    public User(int ID, String firstName, String lastName, int age, Date hd, ContactInformation contactInformation, List<Phone> phoneList) {
        this(ID,firstName,lastName,age,hd);
        this.contactInformation = contactInformation;
        this.phoneList = phoneList;
    }

    public Date getHireDate() {
        return hd;
    }

    public void setHireDate(Date hireDate) {
        this.hd = hireDate;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<Phone> getPhones() {
        return phoneList;
    }

    public void setPhones(List<Phone> phones) {
        this.phoneList = phones;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    @Override
    public String toString() {
        return "\n User{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", contactInformation=" + contactInformation +
                ", phoneList=" + phoneList +
                ", hireDate=" + hd +
                '}';
    }
}
