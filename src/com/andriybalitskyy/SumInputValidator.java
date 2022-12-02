package com.andriybalitskyy;

public class SumInputValidator {
    private String[] args;

    public SumInputValidator(String[] args){
        this.args = args;
    }

    public Input validate() throws IncorrectInputsException {
        if(args.length == 3) {
            String amountInput = args[0];
            String priceInput = args[1];
            String productTypeInput = args[2];
            Integer amount;
            Double price;
            ProductType type;

            if (isInteger(amountInput)) {
                amount = Integer.parseInt(amountInput);
            } else {
                throw new IncorrectInputsException("Wrong amount.");
            }

            if (isDouble(priceInput)) {
                price = Double.parseDouble(priceInput);
            } else {
                throw new IncorrectInputsException("Wrong price.");
            }

            if (checkValueInProductType(productTypeInput)) {
                type = ProductType.valueOf(productTypeInput);
            } else {
                throw new IncorrectInputsException("Wrong product type.");
            }

            return new Input(amount, price, type);
        } else {
            throw new IncorrectInputsException("Missed data.");
        }
    }

    private boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isDouble(String str) {
        if (str == null) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean checkValueInProductType(String test) {

        for (ProductType c : ProductType.values()) {
            if (c.name().equals(test.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}
