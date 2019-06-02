package com.mcserby.training;

import com.mcserby.training.model.ConversionOperation;
import com.mcserby.training.model.ConversionResult;

public class ConversionEngine {

    private final SyntaxParser syntaxParser;
    private final UnitConverter4 unitConverter;

    public ConversionEngine(SyntaxParser syntaxParser, UnitConverter4 unitConverter){
        this.syntaxParser = syntaxParser;
        this.unitConverter = unitConverter;
    }

    public ConversionResult convert(String phrase){
        ConversionOperation conversionOperation = this.syntaxParser.parse(phrase);
        return unitConverter.convert(conversionOperation);
    }
}
