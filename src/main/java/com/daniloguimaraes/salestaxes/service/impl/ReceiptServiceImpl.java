package com.daniloguimaraes.salestaxes.service.impl;

import com.daniloguimaraes.salestaxes.model.Receipt;
import com.daniloguimaraes.salestaxes.service.ProductService;
import com.daniloguimaraes.salestaxes.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return receipt;
    }

    @Override
    public Receipt translateReceiptFromNaturalLanguage(String naturalLangugeReceipt) {
        Receipt receipt = new Receipt();

        String[] products = naturalLangugeReceipt.split("\\n");

        for (String product : products) {
            receipt.getProducts().add(productService.fromNaturalLanguage(product));
        }

        return receipt;
    }
}
