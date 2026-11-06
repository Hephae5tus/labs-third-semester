package org.example.entity;

import java.util.Objects;

public class Helmet extends Ammunition {

    private String size;
    private boolean hasVisor;

    public Helmet(String name, double price, double weight, String size, boolean hasVisor) {
        super(name, price, weight);
        this.size = size;
        this.hasVisor = hasVisor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isHasVisor() {
        return hasVisor;
    }

    public void setHasVisor(boolean hasVisor) {
        this.hasVisor = hasVisor;
    }

    @Override
    public String getType() {
        return "HELMET";
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        Helmet helmet = (Helmet) object;
        return hasVisor == helmet.hasVisor && Objects.equals(size, helmet.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, hasVisor);
    }

    @Override
    public String toString() {
        return "Helmet{name='" + getName() + "', price=" + getPrice()
                + ", weight=" + getWeight() + ", size='" + size
                + "', hasVisor=" + hasVisor + '}';
    }
}
