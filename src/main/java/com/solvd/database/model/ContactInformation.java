package main.java.com.solvd.database.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "contactInformation")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactInformation {
    private String email;
    private Long phoneNumber;
    private int userId;
    @XmlAttribute(name="id")
    private int ID;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", id=" + ID +
                '}';
    }
}
