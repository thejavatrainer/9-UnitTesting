package com.mcserby.training;

import com.mcserby.training.exceptions.ConversionFailedException;
import com.mcserby.training.exceptions.NotImplementedException;
import com.mcserby.training.model.ConversionOperation;
import com.mcserby.training.model.ConversionResult;

public class UnitConverter4 {

    private UnitConverter3 unitConverter = new UnitConverter3();

    public ConversionResult convert(ConversionOperation conversionOperation) throws ConversionFailedException {
        double result = unitConverter.convert(conversionOperation.getFrom(), conversionOperation.getTo(),
                conversionOperation.getValue());
        return new ConversionResult(conversionOperation.getTo(), result);
    }
}
