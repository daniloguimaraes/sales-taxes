package com.daniloguimaraes.salestaxes.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    private List<Product> products;
    private BigDecimal salesTaxes;
    private BigDecimal total;

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

    public void setProducts(List<Product> products) {
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }

        if (salesTaxes != null) {
            sb.append("Sales Taxes: " + salesTaxes).append("\n");
        }

        if (total != null) {
            sb.append("Total: " + total);
        }

        return sb.toString();
    }

}
