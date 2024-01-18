package main.java.com.solvd.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import main.java.com.solvd.database.interfaces.IUserInfo;
import main.java.com.solvd.database.services.designpatterns.adapter.XmlDateAdapter;

import java.util.Date;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements IUserInfo {
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
    public String basicInformation() {
        return "Name: "+ firstName + " " + lastName + " Age: " + age;
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

    public static Builder builder(){
        return new Builder(new User());
    }

    public static class Builder{
        private final User user;
        public Builder(User user){
            this.user = user;
        }
        public Builder id(int id){
            user.ID = id;
            return this;
        }
        public Builder firstName(String firstName){
            user.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            user.lastName = lastName;
            return this;
        }

        public Builder age(int age){
            user.age = age;
            return this;
        }
        public Builder hireDate(Date hireDate){
            user.hd = hireDate;
            return this;
        }
        public Builder contactInformation(ContactInformation contactInformation){
            user.contactInformation = contactInformation;
            return this;
        }
        public Builder phoneList(List<Phone> phoneList){
            user.phoneList = phoneList;
            return this;
        }

        public User build(){
            return user;
        }
    }

}
