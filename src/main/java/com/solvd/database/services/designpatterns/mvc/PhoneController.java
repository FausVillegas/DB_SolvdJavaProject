package main.java.com.solvd.database.services.designpatterns.mvc;

import main.java.com.solvd.database.model.Battery;
import main.java.com.solvd.database.model.OperatingSystem;
import main.java.com.solvd.database.model.Phone;

public class PhoneController {
    private Phone model;
    private PhoneView view = new PhoneView();

    public PhoneController(Phone model) {
        this.model = model;
    }

    public int getId() {
        return model.getId();
    }

    public void setId(int id) {
        this.model.setId(id);
    }

    public String getBrand() {
        return model.getBrand();
    }

    public void setBrand(String brand) {
        this.model.setBrand(brand);
    }

    public String getModel() {
        return model.getModel();
    }

    public void setModel(String model) {
        this.model.setModel(model);
    }

    public OperatingSystem getOperatingSystem() {
        return model.getOperatingSystem();
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.model.setOperatingSystem(operatingSystem);
    }

    public Battery getBattery() {
        return model.getBattery();
    }

    public void setBattery(Battery battery) {
        this.model.setBattery(battery);
    }
    public void updateView() {
        view.printPhoneDetails(model);
    }
}
