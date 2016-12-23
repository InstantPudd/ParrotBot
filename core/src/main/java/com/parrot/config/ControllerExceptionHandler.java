package com.parrot.config;

import com.parrot.validation.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;

//TODO - This may not be necessary once RestEasy is set up
/**
 * The @ControllerAdvice annotation makes it so that this class will
 * apply to all @Controllers in the muni-portal-service module.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(
        BadRequestException e
    ) {
        return new ResponseEntity<>( e.getMessage(), HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(value = NotAuthorizedException.class)
    public ResponseEntity<String> handleNotAuthorizedException(
        NotAuthorizedException e
    ) {
        return new ResponseEntity<>( e.getMessage(), HttpStatus.UNAUTHORIZED );
    }

    @ExceptionHandler(value = ForbiddenException.class)
    public ResponseEntity<String> handleForbiddenException(
        ForbiddenException e
    ) {
        return new ResponseEntity<>( e.getMessage(), HttpStatus.FORBIDDEN );
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(
        NotFoundException e
    ) {
        return new ResponseEntity<>( e.getMessage(), HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler(value = ConflictException.class)
    public ResponseEntity<String> handleConflictException(
        ConflictException e
    ) {
        return new ResponseEntity<>( e.getMessage(), HttpStatus.CONFLICT );
    }
}