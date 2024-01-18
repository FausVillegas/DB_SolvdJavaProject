package main.java.com.solvd.database.services.designpatterns.decorator;

import main.java.com.solvd.database.model.User;

public class Administrator extends UserDecorator{
    public Administrator(User user) {
        super(user);
    }
    @Override
    public String basicInformation(){
        return super.basicInformation() + " (Administrator)";
    }
    @Override
    public User getUser(){
        return super.getUser();
    }
}
