package main.java.com.solvd.database.services.designpatterns.listener;

import main.java.com.solvd.database.model.User;

public interface IUserListener {
    void onNewUser(User user);
    void onUserDeleted(User user);

}
