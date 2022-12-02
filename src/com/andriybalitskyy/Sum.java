package com.andriybalitskyy;

import java.math.BigDecimal;

public class Sum {
    Integer amount;
    Double price;
    ProductType type;

    public Sum(Integer amount, Double price, ProductType type) {
        this.amount = amount;
        this.price = price;
        this.type = type;
    }

    public Result calculate() {
        BigDecimal result = new BigDecimal(amount.toString()).multiply(new BigDecimal(price.toString()));
        if(type == ProductType.book) {
            BigDecimal freight = new BigDecimal(freight());
            result = result.add(freight);
        }

        return new Result(result, Currency.DKK);
    }

    private int freight() {
        int freightSum = 0;
        int freightIterator = amount / 10;
        if(amount%10 != 0) {
            freightIterator++;
        }

        for (int i=0; i<freightIterator; i++) {
            if(i == 0) {
                freightSum += 50;
            } else {
                freightSum += 25;
            }
        }

        return freightSum;
    }
}
