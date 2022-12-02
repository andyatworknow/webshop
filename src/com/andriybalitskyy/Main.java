package com.andriybalitskyy;

public class Main {

    public static void main(String[] args) {
        try{
            SumInputValidator validator = new SumInputValidator(args);
            Input input = validator.validate();

            Sum sum = new Sum(input.getAmount(), input.getPrice(), input.getType());
            Result result = sum.calculate();
            result.print();

        } catch (IncorrectInputsException ex) {
            System.out.println(ex.getMessage());
        }

    }
}