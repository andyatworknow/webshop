package com.andriybalitskyy;

public class InputValidateUtils {
    public static boolean isInteger(String str) {
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

    public static boolean isDouble(String str) {
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

    public static boolean checkValueInProductType(String test) {

        for (ProductType c : ProductType.values()) {
            if (c.name().equals(test.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}
