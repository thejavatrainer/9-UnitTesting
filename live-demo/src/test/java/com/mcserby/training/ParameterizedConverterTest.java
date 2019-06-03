package com.mcserby.training;

import com.mcserby.training.exception.ConversionNotImplementedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedConverterTest {

    @Parameterized.Parameter(0)
    public Unit from;

    @Parameterized.Parameter(1)
    public Unit to;

    @Parameterized.Parameter(2)
    public double value;

    @Parameterized.Parameter(3)
    public double result;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {Unit.METER, Unit.CENTIMETER, 1.0, 100.0},
                {Unit.KILOMETER, Unit.METER, 1.0, 1000.0},
                {Unit.NAUTICAL_MILE, Unit.METER, 1.0, 1852d},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testMultiplyException() throws ConversionNotImplementedException {
        UnitConverter2 unitConverter = new UnitConverter2();
        assertEquals("Conversion should be correct", result, unitConverter.convert(from, to, value), 0.0000000001);
    }

}
