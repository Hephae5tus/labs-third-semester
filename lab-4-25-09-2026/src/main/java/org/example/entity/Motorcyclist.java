package org.example.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Motorcyclist {

    private String name;
    private final List<Ammunition> ammunition;

    public Motorcyclist(String name) {
        this.name = name;
        this.ammunition = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ammunition> getAmmunition() {
        return Collections.unmodifiableList(ammunition);
    }

    public void addAmmunition(Ammunition item) {
        if (item != null) {
            ammunition.add(item);
        }
    }

    public void clearAmmunition() {
        ammunition.clear();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Motorcyclist that = (Motorcyclist) object;
        return Objects.equals(name, that.name) && Objects.equals(ammunition, that.ammunition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ammunition);
    }

    @Override
    public String toString() {
        return "Motorcyclist{name='" + name + "', ammunition=" + ammunition + '}';
    }
}
