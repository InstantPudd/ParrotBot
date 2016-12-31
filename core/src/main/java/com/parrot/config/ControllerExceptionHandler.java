package com.parrot.config;

import com.parrot.validation.ClientErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The @ControllerAdvice annotation makes it so that this class will apply to all @Controllers in the module.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = ClientErrorException.class)
    public ResponseEntity<String> handleBadRequestException(
        ClientErrorException e
    ) {
        return new ResponseEntity<>( e.getMessage(), e.getStatusCode().getHttpStatus() );
    }
}
