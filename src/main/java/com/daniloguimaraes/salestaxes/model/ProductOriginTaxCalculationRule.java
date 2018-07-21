package com.daniloguimaraes.salestaxes.model;

import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * Tax rule based on product origin.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public class ProductOriginTaxCalculationRule implements TaxCalculationRule {

    private final ProductOrigin origin;

    /**
     * Default constructor
     *
     * @param origin the product origin
     */
    public ProductOriginTaxCalculationRule(ProductOrigin origin) {
        Assert.notNull(origin, "The product origin must be not null");

        this.origin = origin;
    }

    @Override
    public BigDecimal taxRate() {
        switch (origin) {
            case IMPORTED:
                return new BigDecimal("0.05");
            default:
                return BigDecimal.ZERO;
        }
    }
}
