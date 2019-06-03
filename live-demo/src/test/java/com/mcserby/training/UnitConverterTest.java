package com.mcserby.training;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitConverterTest {

    private static UnitConverter converter;

    @BeforeClass
    public static void initialize(){
        System.out.println("setUp");
        converter = new UnitConverter();
    }

    @Test
    public void testGiven2kmThenConversionToMetersThenResultIs2000() {
        double result = converter.convertKilometersToMeters(2);
        assertEquals("Conversion should be correct", 2000, result, 0.00001);
    }

    @Ignore
    @Test
    public void shouldFailBecauseNotImplemented(){
        fail("not implemented");
    }

}