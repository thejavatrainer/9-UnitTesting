package com.mcserby.training;

import com.mcserby.training.exception.ConversionFailedException;
import com.mcserby.training.exception.ConversionNotImplementedException;
import com.mcserby.training.model.ConversionOperation;
import com.mcserby.training.model.ConversionResult;

public class UnitConverter4 {

    private UnitConverter2 unitConverter = new UnitConverter2();

    public ConversionResult convert(ConversionOperation conversionOperation) throws ConversionNotImplementedException {
        double result = unitConverter.convert(conversionOperation.getFrom(), conversionOperation.getTo(),
                conversionOperation.getValue());
        return new ConversionResult(conversionOperation.getTo(), result);
    }
}
