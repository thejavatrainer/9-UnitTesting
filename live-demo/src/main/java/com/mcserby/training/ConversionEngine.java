package com.mcserby.training;

import com.mcserby.training.exception.ConversionFailedException;
import com.mcserby.training.exception.ConversionNotImplementedException;
import com.mcserby.training.exception.InvalidPhraseException;
import com.mcserby.training.exception.NotImplementedException;
import com.mcserby.training.model.ConversionOperation;
import com.mcserby.training.model.ConversionResult;

public class ConversionEngine {

    private final SyntaxParser syntaxParser;
    private final UnitConverter4 unitConverter;

    public ConversionEngine(SyntaxParser syntaxParser, UnitConverter4 unitConverter) {
        this.syntaxParser = syntaxParser;
        this.unitConverter = unitConverter;
    }

    public ConversionResult convert(String phrase) throws ConversionFailedException {
        try {
            ConversionOperation conversionOperation = this.syntaxParser.parse(phrase);
            return unitConverter.convert(conversionOperation);
        } catch (InvalidPhraseException | ConversionNotImplementedException | NotImplementedException e) {
            throw new ConversionFailedException(e);
        }
    }
}
