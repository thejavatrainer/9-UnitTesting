package com.mcserby.training;

import com.mcserby.training.exceptions.ConversionFailedException;
import org.junit.Test;

public class ConversionExceptionTest {

    @Test(expected = ConversionFailedException.class)
    public void testGivenUnsupportedFromUnitWhenConversionIsPerformedExceptionIsThrown() throws
            ConversionFailedException {
        new UnitConverter2().convert(Unit.NAUTICAL_MILE, Unit.KILOMETER, 2);
    }
}
