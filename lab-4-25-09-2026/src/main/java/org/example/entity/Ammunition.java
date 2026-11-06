package org.example.entity;

import java.util.Objects;

public abstract class Ammunition {

    private String name;
    private double price;
    private double weight;

    protected Ammunition(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract String getType();

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Ammunition that = (Ammunition) object;
        return Double.compare(that.price, price) == 0
                && Double.compare(that.weight, weight) == 0
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }

    @Override
    public String toString() {
        return getType() + "{name='" + name + "', price=" + price + ", weight=" + weight + '}';
    }
}
