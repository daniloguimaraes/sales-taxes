package com.daniloguimaraes.salestaxes.service.impl;

import com.daniloguimaraes.salestaxes.model.Receipt;
import com.daniloguimaraes.salestaxes.service.ReceiptService;
import org.springframework.stereotype.Service;

/**
 * Default implementation for {@link ReceiptService}
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Override
    public Receipt calculateTaxes(Receipt receipt) {
        return null;
    }
}
