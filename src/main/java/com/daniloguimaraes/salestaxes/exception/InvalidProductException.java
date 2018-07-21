package com.daniloguimaraes.salestaxes.exception;

/**
 * @author Danilo Guimarães
 * @since 21/07/2018
 */
public class InvalidProductException extends ReceiptException {

    public InvalidProductException(String message) {
        super("Invalid product format: " + message);
    }

    public InvalidProductException(String message, Throwable cause) {
        super("Invalid product format: " + message, cause);
    }
}
