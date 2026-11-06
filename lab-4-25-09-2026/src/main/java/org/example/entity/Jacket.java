package org.example.entity;

import java.util.Objects;

public class Jacket extends Ammunition {

    private String material;
    private int protectionLevel;

    public Jacket(String name, double price, double weight, String material, int protectionLevel) {
        super(name, price, weight);
        this.material = material;
        this.protectionLevel = protectionLevel;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getProtectionLevel() {
        return protectionLevel;
    }

    public void setProtectionLevel(int protectionLevel) {
        this.protectionLevel = protectionLevel;
    }

    @Override
    public String getType() {
        return "JACKET";
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        Jacket jacket = (Jacket) object;
        return protectionLevel == jacket.protectionLevel
                && Objects.equals(material, jacket.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), material, protectionLevel);
    }

    @Override
    public String toString() {
        return "Jacket{name='" + getName() + "', price=" + getPrice()
                + ", weight=" + getWeight() + ", material='" + material
                + "', protectionLevel=" + protectionLevel + '}';
    }
}
