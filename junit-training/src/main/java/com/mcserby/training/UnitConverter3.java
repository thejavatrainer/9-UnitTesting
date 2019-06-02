package com.mcserby.training;

import com.mcserby.training.exceptions.ConversionFailedException;
import com.mcserby.training.exceptions.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnitConverter3 {

    private enum ConversionRates {
        METER_TO_CENTIMETER(Unit.METER, Unit.CENTIMETER, 100d),
        KILOMETER_TO_METER(Unit.KILOMETER, Unit.METER, 1000d),
        NAUTICAL_MILE_TO_METER(Unit.NAUTICAL_MILE, Unit.METER, 1852d),
        INCH_TO_CENTIMETER(Unit.INCH, Unit.CENTIMETER, 2.54);

        private final Unit from;
        private final Unit to;
        private final double conversionRate;

        private ConversionRates(Unit from, Unit to, double conversionRate) {
            this.from = from;
            this.to = to;
            this.conversionRate = conversionRate;
        }

        public static double getConversionRate(Unit from, Unit to) throws NotImplementedException {
            List<UnitConverter3.ConversionRates> conversionRates = Stream.of(UnitConverter3.ConversionRates.values())
                    .filter(cr -> cr
                    .from.equals(from) && cr.to.equals(to)).collect(Collectors.toList());
            if (conversionRates.isEmpty()) {
                throw new NotImplementedException("conversion not supported");
            }
            return conversionRates.get(0).conversionRate;
        }
    }

    public double convert(Unit from, Unit to, double value) throws ConversionFailedException {
        try {
            return UnitConverter3.ConversionRates.getConversionRate(from, to) * value;
        } catch (NotImplementedException e) {
            throw new ConversionFailedException(e);
        }
    }
}
