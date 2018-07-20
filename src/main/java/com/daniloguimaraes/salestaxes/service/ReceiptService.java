package com.daniloguimaraes.salestaxes.service;

import com.daniloguimaraes.salestaxes.model.Receipt;

/**
 * Service related to receipts.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public interface ReceiptService {

    Receipt calculateTaxes(Receipt receipt);
}
