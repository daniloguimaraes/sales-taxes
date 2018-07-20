package com.daniloguimaraes.salestaxes.model;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Represents a receipt.
 *
 * <p>
 * A receipt is typically compound by a list of products, the total amount of taxes payed and the receipt total value.
 * </p>
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public class Receipt {

    private Set<Product> products;
    private BigDecimal salesTaxes;
    private BigDecimal total;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public BigDecimal getSalesTaxes() {
        return salesTaxes;
    }

    public void setSalesTaxes(BigDecimal salesTaxes) {
        this.salesTaxes = salesTaxes;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
