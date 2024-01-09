package main.java.com.solvd.database.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import main.java.com.solvd.database.services.Adapter.DateAdapter;
import main.java.com.solvd.database.services.jaxb.JaxB;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement(name = "user")
public class User {
    @XmlAttribute(name="id")
    private int ID;
    private String firstName;
    private String lastName;
    private int age;
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "hireDate")
    private Date hd;
    private ContactInformation contactInformation;
    @XmlElementWrapper(name = "phones")
    @XmlElement(name = "phone")
    private List<Phone> phoneList;


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
