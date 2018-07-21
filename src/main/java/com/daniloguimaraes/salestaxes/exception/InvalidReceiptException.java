package com.daniloguimaraes.salestaxes.exception;

/**
 * @author Danilo Guimarães
 * @since 21/07/2018
 */
public class InvalidReceiptException extends ReceiptException {

    public InvalidReceiptException(String message) {
        super(message);
    }

    public InvalidReceiptException(String message, Throwable cause) {
        super(message, cause);
    }
}
