package com.mcserby.training;

import com.mcserby.training.exception.ConversionFailedException;
import com.mcserby.training.model.ConversionResult;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComponentTest {

    private static ConversionEngine engine;

    @BeforeClass
    public static void initialize() {
        SyntaxParser syntaxParser = new SyntaxParser();
        UnitConverter4 unitConverter = new UnitConverter4();
        engine = new ConversionEngine(syntaxParser, unitConverter);
    }

    @Test
    public void testConversionFromTo() throws ConversionFailedException {
        ConversionResult result = engine.convert("15 nauticalmiles to km");
        assertNotNull(result);
        assertEquals(Unit.KILOMETER, result.getUnit());
        assertEquals(27.78, result.getValue(), 0.000001);
    }
}
