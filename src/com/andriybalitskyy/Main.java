package com.andriybalitskyy;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        try{
            SumInputValidator validator = new SumInputValidator(args);
            Input input = validator.validate();

            StepCalculatable<Double> vatProvider = new VATProvider();
            StepCalculatable<BigDecimal> sumProvider = new SumProvider();
            SubTotalCalculatable<BigDecimal> freightProvider = new FreightProvider();
            SubTotalCalculatable<BigDecimal> currencyExchangeProvider = new CurrencyExchangeProvider();

            Sum sum = new Sum(input, vatProvider, sumProvider, freightProvider, currencyExchangeProvider);
            Result result = sum.calculate();
            result.print();

        } catch (IncorrectInputsException ex) {
            System.out.println(ex.getMessage());
        }

    }
}