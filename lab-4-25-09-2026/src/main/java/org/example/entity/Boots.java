package org.example.entity;

import java.util.Objects;

public class Boots extends Ammunition {

    private int size;
    private double shaftHeight;

    public Boots(String name, double price, double weight, int size, double shaftHeight) {
        super(name, price, weight);
        this.size = size;
        this.shaftHeight = shaftHeight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getShaftHeight() {
        return shaftHeight;
    }

    public void setShaftHeight(double shaftHeight) {
        this.shaftHeight = shaftHeight;
    }

    @Override
    public String getType() {
        return "BOOTS";
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        Boots boots = (Boots) object;
        return size == boots.size && Double.compare(boots.shaftHeight, shaftHeight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, shaftHeight);
    }

    @Override
    public String toString() {
        return "Boots{name='" + getName() + "', price=" + getPrice()
                + ", weight=" + getWeight() + ", size=" + size
                + ", shaftHeight=" + shaftHeight + '}';
    }
}
