package com.andriybalitskyy;

import java.math.BigDecimal;

public class FreightProvider implements SubTotalCalculatable<BigDecimal> {

    @Override
    public BigDecimal calculate(Input input, BigDecimal result) {
        if(input.getType() == ProductType.book) {
            BigDecimal freight = new BigDecimal(freight(input));
            result = result.add(freight);
        }
        return result;
    }

    private int freight(Input input) {
        int freightSum = 0;
        int freightIterator = input.getAmount() / 10;
        if(input.getAmount()%10 != 0) {
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
