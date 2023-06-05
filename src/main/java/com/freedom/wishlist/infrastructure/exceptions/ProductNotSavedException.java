package com.freedom.wishlist.infrastructure.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ProductNotSavedException extends ResponseStatusException {

    public ProductNotSavedException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
