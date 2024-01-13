package main.java.com.solvd.database.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Battery {
    @XmlAttribute(name="id")
    private int id;
    private float capacityMah;

    public Battery() {}

    public Battery(int id, float capacityMah) {
        this.id = id;
        this.capacityMah = capacityMah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCapacityMah() {
        return capacityMah;
    }

    public void setCapacityMah(float capacityMah) {
        this.capacityMah = capacityMah;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "id=" + id +
                ", capacityMah=" + capacityMah +
                '}';
    }
}
