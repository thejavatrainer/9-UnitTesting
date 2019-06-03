package com.mcserby.training;

import com.mcserby.training.exception.ConversionNotImplementedException;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitConverter2Test {

    @Test
    public void testConvertKmToMeters() throws ConversionNotImplementedException {
        UnitConverter2 converter = new UnitConverter2();
        double result = converter.convert(Unit.KILOMETER, Unit.METER, 3.2);
        assertEquals("should convert properly", 3200, result, 0.000001);
    }

    @Test
    public void testConversionInchToCm() throws ConversionNotImplementedException {
        UnitConverter2 converter = new UnitConverter2();
        double result = converter.convert(Unit.INCH, Unit.CENTIMETER, 2);
        assertEquals("should convert properly", 5.08, result, 0.000001);
    }

    @Test(expected = ConversionNotImplementedException.class)
    public void testNauticalMilesToMetres() throws ConversionNotImplementedException {
        UnitConverter2 converter = new UnitConverter2();
        double result = converter.convert(Unit.NAUTICAL_MILE, Unit.METER, 3);
        assertEquals("should convert properly", 5.08, result, 0.000001);
    }
}