package com.mcserby.training;

import com.mcserby.training.exception.ConversionFailedException;
import com.mcserby.training.exception.ConversionNotImplementedException;
import com.mcserby.training.exception.InvalidPhraseException;
import com.mcserby.training.model.ConversionOperation;
import com.mcserby.training.model.ConversionResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConversionEngineTest {

    private ConversionEngine engine;
    final SyntaxParser syntaxParser = mock(SyntaxParser.class);
    final UnitConverter4 unitConverter = mock(UnitConverter4.class);

    @Before
    public void setUp() {
        engine = new ConversionEngine(syntaxParser, unitConverter);
    }

    @Test
    public void convert() throws ConversionFailedException, InvalidPhraseException, ConversionNotImplementedException {
        ConversionOperation operation = new ConversionOperation(Unit.INCH, Unit.METER, 2);
        when(syntaxParser.parse("2 inch to meter")).thenReturn(operation);
        when(unitConverter.convert(operation)).thenReturn(new
                ConversionResult(Unit.METER, 0.0508));
        ConversionResult result = engine.convert("2 inch to meter");
        assertEquals(Unit.METER, result.getUnit());
        assertEquals(0.0508, result.getValue(), 0.00000000001);
    }
}