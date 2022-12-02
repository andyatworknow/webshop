package com.andriybalitskyy;

import java.math.BigDecimal;

public class Sum {
    private final Input input;
    private final StepCalculatable<Double> vatProvider;
    private final StepCalculatable<BigDecimal> sumProvider;
    private final SubTotalCalculatable<BigDecimal> freightProvider;
    private final SubTotalCalculatable<BigDecimal> currencyExchangeProvider;

    public Sum(Input input, StepCalculatable<Double> vatProvider, StepCalculatable<BigDecimal> sumProvider, SubTotalCalculatable<BigDecimal> freightProvider, SubTotalCalculatable<BigDecimal> currencyExchangeProvider) {
        this.input = input;
        this.vatProvider = vatProvider;
        this.sumProvider = sumProvider;
        this.freightProvider = freightProvider;
        this.currencyExchangeProvider = currencyExchangeProvider;
    }

    public Result calculate() {
        input.setPrice(vatProvider.calculate(input));

        BigDecimal result = sumProvider.calculate(input);

        result = freightProvider.calculate(input, result);

        result = currencyExchangeProvider.calculate(input, result);

        return new Result(result, input.getDefaultOutputCurrency());
    }

}
