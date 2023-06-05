package com.freedom.wishlist.infrastructure.exceptions;

import com.freedom.wishlist.core.entities.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ProductNotSavedException.class })
    private ResponseEntity<Object> handleProductNotSavedException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ErrorDetails(new Date(), ex.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = { ProductNotRemovedException.class })
    private ResponseEntity<Object> handleProductNotRemovedException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ErrorDetails(new Date(), ex.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = { WishlistNotFoundException.class })
    private ResponseEntity<Object> handleWishlistNotFoundException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ErrorDetails(new Date(), ex.getMessage()),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
