package com.daniloguimaraes.salestaxes.advice.dto;

import org.springframework.http.HttpStatus;

/**
 * @author Danilo Guimarães
 * @since 21/07/2018
 */
public class ErrorDTO {

    private Integer code;
    private String message;

    public ErrorDTO(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ErrorDTO(HttpStatus status, Exception ex) {
        super();
        this.code = status.value();
        this.message = ex.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "code: " + code + "\nmessage: " + message;
    }
}
