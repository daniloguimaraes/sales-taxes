package com.daniloguimaraes.salestaxes.model;

import java.math.BigDecimal;

/**
 * Abstraction for tax rule calculation.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public interface TaxCalculationRule {

    /**
     *
     * @return an instance of {@link BigDecimal}. Should never returns {@code null}.
     */
    BigDecimal taxRate();
}
