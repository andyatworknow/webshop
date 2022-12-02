package com.andriybalitskyy;

public class SumInputValidator {
    private final String[] args;

    public SumInputValidator(String[] args){
        this.args = args;
    }

    public Input validate() throws IncorrectInputsException {
        int length = args.length;

        if(length >= 3) {
            String amountInput = args[0];
            String priceInput = args[1];
            String productTypeInput = args[2];
            int amount;
            double price;
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

            Input input = new Input(amount, price, type);

            if(length != 3) {
                for (int i = 3; i < length; i++) {
                    String value = args[i];
                    addFlags(input, value);
                }
            }

            return input;
        } else {
            throw new IncorrectInputsException("Missed data.");
        }
    }

    private Input addFlags(Input input, String value) throws IncorrectInputsException {

        String vatFlag = "--" + Flag.vat + "=";
        int vatIndex = value.indexOf(vatFlag);
        if(value.indexOf(vatFlag) != -1) {
            String vatValue = value.substring(vatIndex+vatFlag.length());
            if(checkValueInVAT(vatValue)){
                input.setDefaultVAT(VAT.valueOf(vatValue.toUpperCase()));
            } else {
                throw new IncorrectInputsException("--vat= flag isn't correct.");
            }
        }

        String inputCurrencyFlag = "--" + Flag.inputCurrency.value() + "=";
        int inputCurrencyIndex = value.indexOf(inputCurrencyFlag);
        if(value.indexOf(inputCurrencyFlag) != -1) {
            String inputCurrencyValue = value.substring(inputCurrencyIndex+inputCurrencyFlag.length());
            if(checkValueInCurrency(inputCurrencyValue)) {
                input.setDefaultInputCurrency(Currency.valueOf(inputCurrencyValue.toUpperCase()));
            } else {
                throw new IncorrectInputsException("--input-currency= flag isn't correct.");
            }
        }

        String outputCurrencyFlag = "--" + Flag.outputCurrency.value() + "=";
        int outputCurrencyIndex = value.indexOf(outputCurrencyFlag);
        if(value.indexOf(outputCurrencyFlag) != -1) {
            String outputCurrencyValue = value.substring(outputCurrencyIndex+outputCurrencyFlag.length());
            if(checkValueInCurrency(outputCurrencyValue)) {
                input.setDefaultOutputCurrency(Currency.valueOf(outputCurrencyValue.toUpperCase()));
            } else {
                throw new IncorrectInputsException("--output-currency= flag isn't correct.");
            }
        }

        return input;
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

    private boolean checkValueInVAT(String test) {

        for (VAT c : VAT.values()) {
            if (c.name().equals(test.toUpperCase())) {
                return true;
            }
        }

        return false;
    }

    private boolean checkValueInCurrency(String test) {

        for (Currency c : Currency.values()) {
            if (c.name().equals(test.toUpperCase())) {
                return true;
            }
        }

        return false;
    }
}
