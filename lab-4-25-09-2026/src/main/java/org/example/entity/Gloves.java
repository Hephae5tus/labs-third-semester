package org.example.entity;

import java.util.Objects;

public class Gloves extends Ammunition {

    private String size;
    private boolean waterproof;

    public Gloves(String name, double price, double weight, String size, boolean waterproof) {
        super(name, price, weight);
        this.size = size;
        this.waterproof = waterproof;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isWaterproof() {
        return waterproof;
    }

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    @Override
    public String getType() {
        return "GLOVES";
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        Gloves gloves = (Gloves) object;
        return waterproof == gloves.waterproof && Objects.equals(size, gloves.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, waterproof);
    }

    @Override
    public String toString() {
        return "Gloves{name='" + getName() + "', price=" + getPrice()
                + ", weight=" + getWeight() + ", size='" + size
                + "', waterproof=" + waterproof + '}';
    }
}
