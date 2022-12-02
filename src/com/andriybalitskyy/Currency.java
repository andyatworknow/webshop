package com.andriybalitskyy;

public enum Currency {
    DKK("100"),
    NOK("73.50"),
    SEK("70.23"),
    GBP("891.07"),
    EUR("743.93");

    private final String value;
    Currency(String value) {
        this.value = value;
    }
    public String value() { return value; }
}
