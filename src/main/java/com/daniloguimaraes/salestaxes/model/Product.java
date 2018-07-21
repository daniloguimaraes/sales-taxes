package com.daniloguimaraes.salestaxes.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * A product representation.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public class Product {

    private static final NumberFormat FORMATTER = new DecimalFormat("0.00");

    private Integer amount;
    private String description;
    private ProductOrigin origin;
    private ProductType type;
    private BigDecimal shelfPrice;
    private BigDecimal taxesPrice;
    private BigDecimal totalPrice;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(ProductOrigin origin) {
        this.origin = origin;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public BigDecimal getShelfPrice() {
        return shelfPrice;
    }

    public void setShelfPrice(BigDecimal shelfPrice) {
        this.shelfPrice = shelfPrice;
        updateTotalPrice();
    }

    public BigDecimal getTaxesPrice() {
        return taxesPrice;
    }

    public void setTaxesPrice(BigDecimal taxesPrice) {
        this.taxesPrice = taxesPrice;
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        if (taxesPrice != null) {
            this.totalPrice = shelfPrice.add(taxesPrice);
        } else {
            this.totalPrice = shelfPrice;
        }
    }

    @Override
    public String toString() {
        return amount + (origin.isImported() ? " imported" : "") + " " + description + " at " + FORMATTER.format(totalPrice);
    }

}
