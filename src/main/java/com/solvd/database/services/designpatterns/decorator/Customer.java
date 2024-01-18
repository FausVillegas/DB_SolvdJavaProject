package main.java.com.solvd.database.services.designpatterns.decorator;

import main.java.com.solvd.database.model.User;

public class Customer extends UserDecorator{
    public Customer(User user) {
        super(user);
    }
    @Override
    public String basicInformation(){
        return super.basicInformation() + " (Customer)";
    }
    @Override
    public User getUser(){
        return super.getUser();
    }
}
