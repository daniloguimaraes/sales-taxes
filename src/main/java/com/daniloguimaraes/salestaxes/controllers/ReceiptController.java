package com.daniloguimaraes.salestaxes.controllers;

import com.daniloguimaraes.salestaxes.model.Receipt;
import com.daniloguimaraes.salestaxes.service.ReceiptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Receipt Rest controller
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
@Api("Receipts")
@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    @Autowired
    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    /**
     * Given a receipt, this endpoint will calculate the taxes and return its details in natural language.
     *
     * @param receipt the incoming receipt, in JSON format.
     * @return the receipt in natural language.
     */
    @PostMapping(value = "/details", consumes = "application/json", produces = "text/plain")
    @ApiOperation(value = "Consumes a Receipt in JSON format", notes = "Receipt as JSON file")
    public String details(@RequestBody Receipt receipt) {
        return receiptService.calculateTaxes(receipt).toString();
    }

    /**
     *
     * @param receipt
     * @return the receipt as a JSON
     */
    @PostMapping(value = "/details", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Consumes a Receipt in JSON format", notes = "Given a receipt, it will calculated its details", response = Receipt.class)
    public Receipt detailsAsJson(@RequestBody Receipt receipt) {
        return receiptService.calculateTaxes(receipt);
    }

    /**
     *
     * @param receipt the incoming receipt, in natural language.
     * @return the receipt, in natural language
     */
    @PostMapping(value = "/details/natural", consumes = "text/plain", produces = "text/plain")
    @ApiOperation(value = "Consumes a Receipt in natural language format", notes = "Receipt in natural language")
    public String natural(@RequestBody String receipt) {
        Receipt translatedReceipt = receiptService.translateReceiptFromNaturalLanguage(receipt);
        return receiptService.calculateTaxes(translatedReceipt).toString();
    }

    /**
     *
     * @param receipt
     * @return the receipt as a JSON
     */
    @PostMapping(value = "/details/natural", consumes = "text/plain", produces = "application/json")
    @ApiOperation(value = "Consumes a Receipt in natural language format", notes = "Receipt in natural language")
    public Receipt naturalAsJson(@RequestBody String receipt) {
        Receipt translatedReceipt = receiptService.translateReceiptFromNaturalLanguage(receipt);
        return receiptService.calculateTaxes(translatedReceipt);
    }
}
