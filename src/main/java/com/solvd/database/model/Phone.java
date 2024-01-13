package main.java.com.solvd.database.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {
    @XmlAttribute(name="id")
    private int ID;
    private String brand;
    private String model;
    private OperatingSystem operatingSystem;
    private Battery battery;

    public Phone() {}

    public Phone(int ID, String brand, String model, OperatingSystem operatingSystem, Battery battery) {
        this.ID = ID;
        this.brand = brand;
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.battery = battery;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "ID=" + ID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", operatingSystem=" + operatingSystem +
                ", battery=" + battery +
                '}';
    }
}
