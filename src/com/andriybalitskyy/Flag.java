package com.andriybalitskyy;

public enum Flag {
    vat("vat"),
    inputCurrency("input-currency"),
    outputCurrency("output-currency");

    private final String value;
    Flag(String value) {
        this.value = value;
    }
    public String value() { return value; }
}
