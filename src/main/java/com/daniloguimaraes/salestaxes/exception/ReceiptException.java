package com.daniloguimaraes.salestaxes.exception;

/**
 * @author Danilo Guimarães
 * @since 21/07/2018
 */
public class ReceiptException extends RuntimeException {

    public ReceiptException(String message) {
        super(message);
    }

    public ReceiptException(String message, Throwable cause) {
        super(message, cause);
    }
}
