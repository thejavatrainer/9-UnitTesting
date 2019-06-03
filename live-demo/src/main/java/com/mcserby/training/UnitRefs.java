package com.mcserby.training;

import com.mcserby.training.exception.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum UnitRefs {

    KILOMETERS(Unit.KILOMETER, "KM", "KILOMETERS", "KILOM"),
    METERS(Unit.METER, "M", "METRES"),
    CENTIMETERS(Unit.CENTIMETER, "CM", "CENTIMETERS"),
    INCHES(Unit.INCH, "IN",  "INCH", "INCHES"),
    NAUTICAL_MILES(Unit.NAUTICAL_MILE, "NM", "NAUTICAL_MILES", "NAUTICALMILES");



    private Unit unit;
    private List<String> representations;

    UnitRefs(Unit unit, String... representations) {
        this.unit = unit;
        this.representations = new ArrayList<>(Arrays.asList(representations));
    }

    public static Unit getUnit(String representation) {
        for (UnitRefs element : UnitRefs.values()) {
            if (element.representations.contains(representation.toUpperCase())) {
                return element.unit;
            }
        }
        throw new NotImplementedException("not imp");
    }
}
