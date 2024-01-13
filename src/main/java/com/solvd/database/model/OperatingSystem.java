package main.java.com.solvd.database.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class OperatingSystem {
    String name;
    @XmlAttribute(name="id")
    int ID;

    public OperatingSystem() {}

    public OperatingSystem(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return ID;
    }
    public void setId(int id) {
        this.ID = id;
    }

    @Override
    public String toString() {
        return "OperatingSystem{" +
                "name='" + name + '\'' +
                ", id=" + ID +
                '}';
    }
}
