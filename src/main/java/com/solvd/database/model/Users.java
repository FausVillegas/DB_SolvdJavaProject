package main.java.com.solvd.database.model;

import jakarta.xml.bind.annotation.*;
import main.java.com.solvd.database.services.designpatterns.listener.ListenersHolders;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
    @XmlElement(name = "user")
    private List<User> usersList = new ArrayList<>();

    public List<User> getUsers() {
        return usersList;
    }

    public void setUsers(List<User> users) {
        this.usersList = users;
    }

    public void addUser(User user){
        ListenersHolders.onNewUser(user);
        usersList.add(user);
    }
    public void removeUser(User user){
        ListenersHolders.onUserDeleted(user);
        usersList.remove(user);
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersList=" + usersList +
                '}';
    }
}
