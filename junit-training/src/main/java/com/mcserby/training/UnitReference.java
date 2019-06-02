package com.mcserby.training;

import com.mcserby.training.exceptions.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum UnitReference {

    KILOMETERS(Unit.KILOMETER, "KM", "KILOMETERS"),
    METERS(Unit.METER, "M", "METRES"),
    CENTIMETERS(Unit.CENTIMETER, "CM", "CENTIMETERS"),
    INCHES(Unit.INCH, "IN", "INCHES"),
    NAUTICAL_MILES(Unit.NAUTICAL_MILE, "NM", "NAUTICAL_MILES");

    private Unit unit;
    private List<String> representations;

    UnitReference(Unit unit, String... representations) {
        this.unit = unit;
        this.representations = new ArrayList<>(Arrays.asList(representations));
    }

    public static Unit getUnit(String representation) {
        for (UnitReference element : UnitReference.values()) {
            if (element.representations.contains(representation.toUpperCase())) {
                return element.unit;
            }
        }
        throw new NotImplementedException();
    }

}
