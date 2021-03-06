package com.daniloguimaraes.salestaxes.service;

import com.daniloguimaraes.salestaxes.exception.InvalidProductException;
import com.daniloguimaraes.salestaxes.model.Product;

import java.math.BigDecimal;

/**
 * Service related to products.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public interface ProductService {

    /**
     * Transform a natural languge product in an instance of {@link Product}.
     *
     * @param naturalLanguageProduct the product represented in natural language.
     * @return an instance of {@link Product}.
     */
    Product fromNaturalLanguage(String naturalLanguageProduct) throws InvalidProductException;

    /**
     *
     * @param product
     * @return
     */
    BigDecimal calculateTaxes(Product product);
}
