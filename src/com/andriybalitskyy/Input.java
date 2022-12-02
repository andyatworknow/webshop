package com.andriybalitskyy;

public class Input {
    private Integer amount;
    private Double price;
    private ProductType type;

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
}
