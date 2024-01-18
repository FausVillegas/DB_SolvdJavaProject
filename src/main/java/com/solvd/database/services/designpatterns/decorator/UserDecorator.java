package main.java.com.solvd.database.services.designpatterns.decorator;

import main.java.com.solvd.database.interfaces.IUserInfo;
import main.java.com.solvd.database.model.User;

public class UserDecorator implements IUserInfo {
    private final User user;

    public UserDecorator(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }

    @Override
    public String basicInformation() {
        return this.user.basicInformation();
    }
}
