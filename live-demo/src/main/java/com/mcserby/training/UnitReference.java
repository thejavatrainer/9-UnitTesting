package com.mcserby.training;

import com.mcserby.training.exception.ConversionNotImplementedException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UnitReference {

    KILOMETER_TO_METER(Unit.KILOMETER, Unit.METER, 1000d),
    INCH_TO_CENTIMETER(Unit.INCH, Unit.CENTIMETER, 2.54),
    METER_TO_CENTIMETER(Unit.METER, Unit.CENTIMETER, 100),
    NAUTICAL_MILE_TO_METER(Unit.NAUTICAL_MILE, Unit.METER, 1852d),
    NAUTICAL_MILE_TO_KILOMETER(Unit.NAUTICAL_MILE, Unit.KILOMETER, 1.852);

    private final Unit from;
    private final Unit to;
    private final double value;

    UnitReference(Unit from, Unit to, double value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }


    public static double getRatio(Unit from, Unit to) throws ConversionNotImplementedException {
        Stream<UnitReference> streamOfResult = Stream.of(UnitReference.values()).filter(ref -> ref.from.equals(from)
                && ref.to.equals(to));
        List<UnitReference> ref = streamOfResult.collect(Collectors.toList());
        if (ref.isEmpty()) {
            throw new ConversionNotImplementedException(from + " to " + to + " conversion not supported");
        }
        return ref.get(0).value;
    }
}
