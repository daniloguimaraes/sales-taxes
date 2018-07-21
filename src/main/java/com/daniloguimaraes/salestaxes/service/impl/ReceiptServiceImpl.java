package com.daniloguimaraes.salestaxes.service.impl;

import com.daniloguimaraes.salestaxes.exception.InvalidProductException;
import com.daniloguimaraes.salestaxes.exception.InvalidReceiptException;
import com.daniloguimaraes.salestaxes.model.Product;
import com.daniloguimaraes.salestaxes.model.Receipt;
import com.daniloguimaraes.salestaxes.service.ProductService;
import com.daniloguimaraes.salestaxes.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Default implementation of {@link ReceiptService}.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ProductService productService;

    @Autowired
    public ReceiptServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Receipt calculateTaxes(Receipt receipt) {
        for (Product product : receipt.getProducts()) {
            BigDecimal productTax = productService.calculateTaxes(product);
            product.setTaxesPrice(productTax);

            receipt.addSalesTaxes(productTax);
        }

        receipt.addTotal(receipt.getSalesTaxes());
        return receipt;
    }

    @Override
    public Receipt translateReceiptFromNaturalLanguage(String naturalLangugeReceipt) throws InvalidReceiptException {
        Receipt receipt = new Receipt();

        String[] products = naturalLangugeReceipt.split("\\n");

        for (String line : products) {
            try {
                final Product product = productService.fromNaturalLanguage(line);
                receipt.addProduct(product);

                receipt.setTotal(receipt.getTotal().add(product.getShelfPrice()));
            } catch (InvalidProductException e) {
                throw new InvalidReceiptException("Invalid receipt", e);
            }
        }

        return receipt;
    }
}
