package com.mcserby.training.model;

import com.mcserby.training.Unit;

public class ConversionResult {

    private final Unit unit;
    private final double value;

    public ConversionResult(Unit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ConversionResult{" +
                "unit=" + unit +
                ", value=" + value +
                '}';
    }
}
