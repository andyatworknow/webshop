package com.andriybalitskyy;

import java.math.BigDecimal;

public class Result {
    BigDecimal sum;
    Currency currency;

    public Result(BigDecimal sum, Currency currency) {
        this.sum = sum;
        this.currency = currency;
    }

    public void print() {
        System.out.println(sum + " " + currency.toString());
    }
}
