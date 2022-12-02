package com.andriybalitskyy;

public class Main {

    public static void main(String[] args) {
        try{
            if(args.length == 3) {
                String amountInput = args[0];
                String priceInput = args[1];
                String productTypeInput = args[2];
                Integer amount = 0;
                Double price = 0.0;
                ProductType type = null;

                if (InputValidateUtils.isInteger(amountInput)) {
                    amount = Integer.parseInt(amountInput);
                } else {
                    throw new IncorrectInputsException("Wrong amount.");
                }

                if (InputValidateUtils.isDouble(priceInput)) {
                    price = Double.parseDouble(priceInput);
                } else {
                    throw new IncorrectInputsException("Wrong price.");
                }

                if (InputValidateUtils.checkValueInProductType(productTypeInput)) {
                    type = ProductType.valueOf(productTypeInput);
                } else {
                    throw new IncorrectInputsException("Wrong product type.");
                }

                Sum sum = new Sum(amount, price, type);
                System.out.println(sum.calculate());
            } else {
                throw new IncorrectInputsException("Missed data.");
            }
        } catch (IncorrectInputsException ex) {
            System.out.println(ex.getMessage());
        }

    }
}