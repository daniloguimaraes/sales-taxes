package com.daniloguimaraes.salestaxes.service;

import com.daniloguimaraes.salestaxes.exception.InvalidReceiptException;
import com.daniloguimaraes.salestaxes.model.Receipt;

/**
 * Service related to receipts.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public interface ReceiptService {

    /**
     * Given a receipt, calculate its taxes.
     *
     * @param receipt the incoming receipt.
     * @return the receipt, with taxes.
     */
    Receipt calculateTaxes(Receipt receipt);

    /**
     * The receipt MUST respect the following pattern:
     *
     * <p>
     * {@code {amount} {origin} {product description} at {price}}
     * </p>
     *
     * Where:
     *
     * <ul>
     *     <li>{@code amount} must be an integer, mandatory.</li>
     *     <li>{@code origin} must be 'imported' or nothing, optional.</li>
     *     <li>{@code product description} must be an String followed by 'at', mandatory.</li>
     *     <li>{@code price} must be an floating-point number using dot (.), mandatory.</li>
     * </ul>
     *
     * Valid examples could be:
     *
     * <pre>
     * 1 book at 12.49
     * 1 music CD at 14.99
     * 1 chocolate bar at 0.85
     * 1 imported box of chocolates at 10.00
     * 1 imported bottle of perfume at 47.50
     * 1 imported bottle of perfume at 27.99
     * 1 bottle of perfume at 18.99
     * 1 packet of headache pills at 9.75
     * 1 imported box of chocolates at 11.25
     * </pre>
     *
     * @param naturalLangugeReceipt the receipt, in natural language.
     * @return an instance of {@link Receipt}.
     */
    Receipt translateReceiptFromNaturalLanguage(String naturalLangugeReceipt) throws InvalidReceiptException;
}
