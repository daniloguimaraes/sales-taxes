package com.daniloguimaraes.salestaxes.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
@ApiModel("Receipt")
public class Receipt {

    private static final NumberFormat FORMATTER = new DecimalFormat("0.00");

    @ApiModelProperty(name = "Products", required = true)
    private List<Product> products;
    @ApiModelProperty(name = "Sales Taxes", required = true)
    private BigDecimal salesTaxes;
    @ApiModelProperty(name = "Total", required = true)
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

    public void addSalesTaxes(BigDecimal salesTaxes) {
        if (this.salesTaxes == null) {
            this.salesTaxes = BigDecimal.ZERO;
        }

        if (salesTaxes != null) {
            this.salesTaxes = this.salesTaxes.add(salesTaxes);
        }
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void addTotal(BigDecimal partial) {
        if (this.total == null) {
            this.total = BigDecimal.ZERO;
        }

        if (partial != null) {
            this.total = this.total.add(partial);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }


        if (salesTaxes != null) {
            sb.append("Sales Taxes: " + FORMATTER.format(salesTaxes)).append("\n");
        }

        if (total != null) {
            sb.append("Total: " + FORMATTER.format(total));
        }

        return sb.toString();
    }

}
