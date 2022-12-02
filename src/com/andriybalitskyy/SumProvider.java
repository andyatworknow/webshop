package com.andriybalitskyy;

import java.math.BigDecimal;

public class SumProvider implements StepCalculatable<BigDecimal> {

    @Override
    public BigDecimal calculate(Input input) {
        return new BigDecimal(input.getAmount().toString()).multiply(new BigDecimal(input.getPrice().toString()));
    }
}
