package com.andriybalitskyy;

public class Input {
    private Integer amount;
    private Double price;
    private ProductType type;
    private VAT defaultVAT = VAT.NO_SPECIFIC_COUNTRY;
    private Currency defaultInputCurrency = Currency.DKK;
    private Currency defaultOutputCurrency = Currency.DKK;

    public Input(Integer amount, Double price, ProductType type) {
        this.amount = amount;
        this.price = price;
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getPrice() {
        return price;
    }

    public ProductType getType() {
        return type;
    }

    public VAT getDefaultVAT() {
        return defaultVAT;
    }

    public Currency getDefaultInputCurrency() {
        return defaultInputCurrency;
    }

    public Currency getDefaultOutputCurrency() {
        return defaultOutputCurrency;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void setDefaultVAT(VAT defaultVAT) {
        this.defaultVAT = defaultVAT;
    }

    public void setDefaultInputCurrency(Currency defaultInputCurrency) {
        this.defaultInputCurrency = defaultInputCurrency;
    }

    public void setDefaultOutputCurrency(Currency defaultOutputCurrency) {
        this.defaultOutputCurrency = defaultOutputCurrency;
    }
}
