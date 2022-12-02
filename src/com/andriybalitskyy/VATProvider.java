package com.andriybalitskyy;

import java.util.HashMap;
import java.util.Map;

public class VATProvider implements StepCalculatable<Double> {
    private final Map<VAT, Map<ProductType, Integer>> vats = new HashMap<>();

    public VATProvider() {
        Map<ProductType, Integer> nsc = new HashMap<>();
        nsc.put(ProductType.all, 0);
        vats.put(VAT.NO_SPECIFIC_COUNTRY, nsc);

        Map<ProductType, Integer> dk = new HashMap<>();
        dk.put(ProductType.all, 25);
        vats.put(VAT.DK, dk);

        Map<ProductType, Integer> no = new HashMap<>();
        no.put(ProductType.all, 25);
        vats.put(VAT.NO, no);

        Map<ProductType, Integer> se = new HashMap<>();
        se.put(ProductType.all, 25);
        vats.put(VAT.SE, se);

        Map<ProductType, Integer> gb = new HashMap<>();
        gb.put(ProductType.all, 20);
        vats.put(VAT.GB, gb);

        Map<ProductType, Integer> de = new HashMap<>();
        de.put(ProductType.book, 12);
        de.put(ProductType.online, 19);
        vats.put(VAT.DE, de);
    }

    @Override
    public Double calculate(Input input) {
        VAT vat = input.getDefaultVAT();
        ProductType productType = input.getType();

        for (VAT currentVAT: vats.keySet()) {
            if(currentVAT.equals(vat)) {
                Map<ProductType, Integer> productTypeVats = vats.get(currentVAT);
                boolean existProductType = false;
                for (ProductType currentProductType : productTypeVats.keySet()) {
                    if(currentProductType.equals(productType)) {
                        Integer vatCountryValue = productTypeVats.get(productType);
                        existProductType = true;
                        if(vatCountryValue != 0) {
                            return input.getPrice() + input.getPrice() * vatCountryValue / 100;
                        }
                    }
                }
                if(!existProductType) {
                    for (ProductType currentProductType : productTypeVats.keySet()) {
                        if(currentProductType.equals(ProductType.all)) {
                            Integer vatCountryValue = productTypeVats.get(ProductType.all);
                            if(vatCountryValue != 0) {
                                return input.getPrice() + input.getPrice() * vatCountryValue / 100;
                            }
                        }
                    }
                }
            }
        }
        return input.getPrice();
    }
}
