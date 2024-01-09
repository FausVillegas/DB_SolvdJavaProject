package main.java.com.solvd.database.model;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Battery {
    @XmlAttribute(name="id")
    private int ID;
    private float capacityMah;

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
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
                "id=" + ID +
                ", capacityMah=" + capacityMah +
                '}';
    }
}
