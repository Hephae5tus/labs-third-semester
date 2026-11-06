package org.example.comparator;

import org.example.entity.Ammunition;

import java.util.Comparator;

public class AmmunitionWeightComparator implements Comparator<Ammunition> {

    @Override
    public int compare(Ammunition first, Ammunition second) {
        return Double.compare(first.getWeight(), second.getWeight());
    }
}
