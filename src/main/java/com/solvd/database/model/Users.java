package main.java.com.solvd.database.model;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import main.java.com.solvd.database.services.jaxb.JaxB;

import java.time.LocalDate;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
    @XmlElement(name = "user")
    private List<User> usersList;

    public List<User> getUsers() {
        return usersList;
    }

    public void setUsers(List<User> users) {
        this.usersList = users;
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersList=" + usersList +
                '}';
    }
}
