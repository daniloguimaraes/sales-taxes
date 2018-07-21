package com.daniloguimaraes.salestaxes.advice;

import com.daniloguimaraes.salestaxes.advice.dto.ErrorDTO;
import com.daniloguimaraes.salestaxes.exception.InvalidProductException;
import com.daniloguimaraes.salestaxes.exception.InvalidReceiptException;
import com.daniloguimaraes.salestaxes.exception.ReceiptException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Danilo Guimarães
 * @since 21/07/2018
 */
@ControllerAdvice(annotations = RestController.class)
public class ErrorControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({InvalidReceiptException.class, ReceiptException.class, InvalidProductException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity badRequest(HttpServletRequest req, Exception ex) {
        final ErrorDTO errorDTO = new ErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<>(errorDTO.toString(), headers, HttpStatus.BAD_REQUEST);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity internalServerError(HttpServletRequest req, RuntimeException ex) {
        long timestamp = System.currentTimeMillis();
        String message = String.format("Unexpected failure during request processing, please contact support team (timestamp: %d).", timestamp);
        final ErrorDTO errorDTO =  new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
    }
}
