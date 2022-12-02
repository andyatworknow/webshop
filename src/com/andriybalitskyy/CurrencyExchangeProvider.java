package com.andriybalitskyy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyExchangeProvider implements SubTotalCalculatable<BigDecimal> {

    @Override
    public BigDecimal calculate(Input input, BigDecimal result) {

        if(!input.getDefaultInputCurrency().equals(input.getDefaultOutputCurrency())) {
            Double defInputCurrency = Double.parseDouble(input.getDefaultInputCurrency().value()) ;
            Double defOutputCurrency = Double.parseDouble(input.getDefaultOutputCurrency().value());
            Double diveded = defInputCurrency/defOutputCurrency;

            result = result.multiply(new BigDecimal(diveded.toString()));
            result = result.setScale(2, RoundingMode.CEILING);

        }

        return result;
    }
}
