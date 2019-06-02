package com.mcserby.training;

import com.mcserby.training.model.ConversionOperation;
import com.mcserby.training.model.ConversionResult;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConversionEngineTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private SyntaxParser syntaxParser;

    @Mock
    private UnitConverter4 unitConverter;

    @Test
    public void convert() {
        /// SyntaxParser syntaxParser = mock(SyntaxParser.class);
        ConversionEngine engine = new ConversionEngine(syntaxParser, unitConverter);
        ConversionOperation operation = new ConversionOperation(Unit.METER, Unit.CENTIMETER, 2d);
        when(syntaxParser.parse("2 m to cm")).thenReturn(operation);
        when(unitConverter.convert(operation)).thenReturn(new
                ConversionResult(Unit.CENTIMETER, 200d));
        ConversionResult result = engine.convert("2 m to cm");
        assertEquals("result should be 200", 200d, result.getValue(), 0.0001);
    }
}