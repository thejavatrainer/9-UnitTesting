package com.mcserby.training;

import com.mcserby.training.exceptions.ConversionFailedException;
import com.mcserby.training.exceptions.NotImplementedException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WithInitializationTest {

    private static UnitConverter3 converter;

    @BeforeClass
    public static void initAll() {
        converter = new UnitConverter3();
    }

    @Before
    public void setUp() {
        System.out.println("new test is being run");
    }

    @Test
    public void testGivenSomethingSomewhereSomehow() throws ConversionFailedException {
        converter.convert(Unit.NAUTICAL_MILE, Unit.METER, 2);
        fail("failing on purpose");
    }

    @Test
    public void testGivenSomethingSomewhereSomehow2() throws ConversionFailedException {
        assertEquals("inch to cm conversion", 5.08, converter.convert(Unit.INCH, Unit.CENTIMETER, 2), 0.0000001);
    }

    @Test
    public void testGivenSomethingSomewhereSomehow3() throws ConversionFailedException {
        assertEquals("meter to cm", 100, converter.convert(Unit.METER, Unit.CENTIMETER, 1), 0.0000001);
    }

    @Test(expected = ConversionFailedException.class)
    public void testExpectedException() throws ConversionFailedException {
        converter.convert(Unit.METER, Unit.INCH, 1);
    }

    @After
    public void tearDown() {
        System.out.println("cleaning up...");
    }

}
