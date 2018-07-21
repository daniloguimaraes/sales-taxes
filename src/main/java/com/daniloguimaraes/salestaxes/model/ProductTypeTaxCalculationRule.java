package com.daniloguimaraes.salestaxes.model;

import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * Tax rule based on product type.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public class ProductTypeTaxCalculationRule implements TaxCalculationRule {

    private final ProductType type;

    /**
     * Default constructor
     *
     * @param type the product type
     */
    public ProductTypeTaxCalculationRule(ProductType type) {
        Assert.notNull(type, "The product type must be not null");

        this.type = type;
    }

    @Override
    public BigDecimal taxRate() {
        switch (type) {
            case BOOK:
            case FOOD:
            case MEDICAL:
                return BigDecimal.ZERO;
            default:
                return new BigDecimal("0.1");
        }
    }
}
