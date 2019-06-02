package com.mcserby.training.model;

import com.mcserby.training.Unit;

public class ConversionOperation {

    private final Unit from;
    private final Unit to;
    private final double value;

    public ConversionOperation(Unit from, Unit to, double value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public Unit getFrom() {
        return from;
    }

    public Unit getTo() {
        return to;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ConversionOperation{" +
                "from=" + from +
                ", to=" + to +
                ", value=" + value +
                '}';
    }
}
