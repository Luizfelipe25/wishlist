package com.freedom.wishlist.infrastructure.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ProductNotSavedException extends RuntimeException {

    public ProductNotSavedException(String reason) {
        super(reason);
    }
}
