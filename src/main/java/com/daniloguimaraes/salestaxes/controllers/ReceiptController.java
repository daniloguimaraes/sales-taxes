package com.daniloguimaraes.salestaxes.controllers;

import com.daniloguimaraes.salestaxes.model.Receipt;
import com.daniloguimaraes.salestaxes.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Receipt Rest controller
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
@RestController("/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    @Autowired
    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    /**
     *
     * @param receipt
     * @return
     */
    @PostMapping(value = "/details", consumes = "application/json")
    public Receipt details(@RequestBody Receipt receipt) {
        return receipt;
    }
}
