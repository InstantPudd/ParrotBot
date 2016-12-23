package com.parrot.validation;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;

public class Validation {

    public static void badRequest(boolean expression) {
        if( ! expression ) {
            throw new BadRequestException();
        }
    }

    public static void badRequest(boolean expression, String errorMessage) {
        if( ! expression ) {
            throw new BadRequestException(errorMessage);
        }
    }

    public static void badRequestNotNull(Object thing) {
        if( thing == null ) {
            throw new BadRequestException();
        }
    }

    public static void badRequestNotNull(Object thing, String errorMessage) {
        if( thing == null ) {
            throw new BadRequestException(errorMessage);
        }
    }

    public static void unauthorized(boolean expression) {
        if( ! expression ) {
            //Not sure why there's no empty constructor for this exception
            throw new NotAuthorizedException("");
        }
    }

    public static void unauthorized(boolean expression, String errorMessage) {
        if( ! expression ) {
            throw new NotAuthorizedException(errorMessage, new Object());
        }
    }

    public static void forbidden(boolean expression) {
        if( ! expression ) {
            throw new ForbiddenException();
        }
    }

    public static void forbidden(boolean expression, String errorMessage) {
        if( ! expression ) {
            throw new ForbiddenException(errorMessage);
        }
    }

    public static void notFound(boolean expression) {
        if( ! expression ) {
            throw new NotFoundException();
        }
    }

    public static void notFound(boolean expression, String errorMessage) {
        if( ! expression ) {
            throw new NotFoundException(errorMessage);
        }
    }

    public static void notFoundNotNull(Object thing, String errorMessage) {
        if( thing == null ) {
            throw new NotFoundException(errorMessage);
        }
    }

    public static void notFoundNotNull(Object thing) {
        if( thing == null ) {
            throw new NotFoundException();
        }
    }

    public static void conflict(boolean expression) {
        if( ! expression ) {
            throw new ConflictException();
        }
    }

    public static void conflict(boolean expression, String errorMessage) {
        if( ! expression ) {
            throw new ConflictException(errorMessage);
        }
    }
}