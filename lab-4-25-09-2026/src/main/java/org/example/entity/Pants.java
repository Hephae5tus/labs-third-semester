package org.example.entity;

import java.util.Objects;

public class Pants extends Ammunition {

    private String material;
    private boolean hasKneePads;

    public Pants(String name, double price, double weight, String material, boolean hasKneePads) {
        super(name, price, weight);
        this.material = material;
        this.hasKneePads = hasKneePads;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isHasKneePads() {
        return hasKneePads;
    }

    public void setHasKneePads(boolean hasKneePads) {
        this.hasKneePads = hasKneePads;
    }

    @Override
    public String getType() {
        return "PANTS";
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        Pants pants = (Pants) object;
        return hasKneePads == pants.hasKneePads && Objects.equals(material, pants.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), material, hasKneePads);
    }

    @Override
    public String toString() {
        return "Pants{name='" + getName() + "', price=" + getPrice()
                + ", weight=" + getWeight() + ", material='" + material
                + "', hasKneePads=" + hasKneePads + '}';
    }
}
