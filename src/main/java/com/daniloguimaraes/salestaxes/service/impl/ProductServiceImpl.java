package com.daniloguimaraes.salestaxes.service.impl;

import com.daniloguimaraes.salestaxes.exception.InvalidProductException;
import com.daniloguimaraes.salestaxes.model.Product;
import com.daniloguimaraes.salestaxes.model.ProductOrigin;
import com.daniloguimaraes.salestaxes.model.ProductOriginTaxCalculationRule;
import com.daniloguimaraes.salestaxes.model.ProductType;
import com.daniloguimaraes.salestaxes.model.ProductTypeTaxCalculationRule;
import com.daniloguimaraes.salestaxes.model.TaxCalculationRule;
import com.daniloguimaraes.salestaxes.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Default implementation of {@link ProductService}.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
@Service
public class ProductServiceImpl implements ProductService {

    /**
     * Examples:
     *
     * <p>
     *     1 chocolate bar at 0.85
     *     1 imported chocolate bar at 0.85
     * </p>
     */
    private static final String PRODUCT_REGEX = "([1-9]{1}[0-9]{0,10} )(imported )?(.*)( at )([0-9]{1,}\\.[0-9]{2})";
    private static final Pattern PRODUCT_PATTERN = Pattern.compile(PRODUCT_REGEX);
    private static final int GROUP_AMOUNT = 1;
    private static final int GROUP_IMPORTED = 2;
    private static final int GROUP_DESCRIPTION = 3;
    private static final int GROUP_PRICE = 5;

    @Override
    public Product fromNaturalLanguage(String naturalLanguageProduct) throws InvalidProductException {
        Product product;

        Matcher m = PRODUCT_PATTERN.matcher(naturalLanguageProduct);

        if (m.matches()) {
            product = new Product();

            product.setAmount(Integer.valueOf(m.group(GROUP_AMOUNT).trim()));
            final String imported = m.group(GROUP_IMPORTED);
            if (imported != null && imported.trim().equals("imported")) {
                product.setOrigin(ProductOrigin.IMPORTED);
            } else {
                product.setOrigin(ProductOrigin.NATIONAL);
            }
            product.setDescription(m.group(GROUP_DESCRIPTION));
            product.setShelfPrice(new BigDecimal(m.group(GROUP_PRICE).trim()));

            product.setType(ProductType.infer(product.getDescription()));
        } else {
            throw new InvalidProductException(naturalLanguageProduct);
        }

        return product;
    }

    @Override
    public BigDecimal calculateTaxes(Product product) {
        BigDecimal taxRate = BigDecimal.ZERO;

        Set<TaxCalculationRule> rules = new HashSet<>();

        rules.add(new ProductOriginTaxCalculationRule(product.getOrigin()));
        rules.add(new ProductTypeTaxCalculationRule(product.getType()));

        for (TaxCalculationRule rule : rules) {
            taxRate = taxRate.add(rule.taxRate());
        }

        return product.getShelfPrice().multiply(taxRate);
    }

}
