package com.daniloguimaraes.salestaxes.model;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * Product type. Differents types of products has differents taxes rules applied.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public enum ProductType {

    BOOK,
    FOOD,
    MEDICAL,
    OTHER;

    /**
     * Try to infer, based on product description, which product type it is.
     *
     * <p>
     * Actually, this implementation is not safe at all because it doesn't ensure all kind of product.
     * </p>
     *
     * @param description the product description
     * @return the {@link ProductType} or {@code null} (when {@code description} is null or empty)
     */
    public static ProductType infer(String description) {
        ProductType type = null;

        if (!StringUtils.isEmpty(description)) {
            if (description.toLowerCase().contains("book")) {
                type = BOOK;
            } else if (description.toLowerCase().contains("chocolate")) {
                type = FOOD;
            } else if (description.toLowerCase().contains("pills")) {
                type = MEDICAL;
            } else {
                type = OTHER;
            }
        }

        return type;

    }
}
