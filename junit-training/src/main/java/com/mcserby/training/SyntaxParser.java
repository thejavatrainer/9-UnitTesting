package com.mcserby.training;

import com.mcserby.training.exceptions.InvalidPhraseException;
import com.mcserby.training.model.ConversionOperation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SyntaxParser {

    public ConversionOperation parse(String phrase) throws InvalidPhraseException {
        List<String> parts = Stream.of(phrase.split(" ")).collect(Collectors.toList());
        if (parts.isEmpty() || parts.size() != 4) {
            throw new InvalidPhraseException("could not parse phrase: " + phrase);
        }
        double value = Double.parseDouble(parts.get(0));
        Unit from = UnitReference.getUnit(parts.get(1));
        Unit to = UnitReference.getUnit(parts.get(3));
        return new ConversionOperation(from, to, value);
    }
}
