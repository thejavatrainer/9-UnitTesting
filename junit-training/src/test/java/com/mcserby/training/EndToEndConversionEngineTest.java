package com.mcserby.training;

import com.mcserby.training.exceptions.ConversionFailedException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndToEndConversionEngineTest {

    private static ConversionEngine conversionEngine;

    @BeforeClass
    public static void initialize(){
        conversionEngine = new ConversionEngine(new SyntaxParser(), new UnitConverter4());
    }

    @Test
    public void testGivenPhraseMetersToCmThenResultValid() throws ConversionFailedException {
        assertEquals(Unit.CENTIMETER, conversionEngine.convert("14 m to cm").getUnit());
        assertEquals(1400, conversionEngine.convert("14 m to cm").getValue(), 0.001);

    }
}
