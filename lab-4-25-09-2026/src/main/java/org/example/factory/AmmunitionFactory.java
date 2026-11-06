package org.example.factory;

import org.example.entity.Ammunition;

public interface AmmunitionFactory {

    Ammunition create(String type, String[] parts);
}
