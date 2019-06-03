package com.mcserby.training;

import com.mcserby.training.exception.ConversionNotImplementedException;

public class UnitConverter2 {

    public double convert(Unit from, Unit to, double value) throws ConversionNotImplementedException {
        return UnitReference.getRatio(from, to) * value;
    }
}
