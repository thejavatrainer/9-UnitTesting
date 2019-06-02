package com.mcserby.training;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitsConverterTest {

    @Test
    public void convertKmToMeters() {
        UnitsConverter converter = new UnitsConverter();
        assertEquals(1000, converter.convertKmToMeters(1), .001);
    }
}

