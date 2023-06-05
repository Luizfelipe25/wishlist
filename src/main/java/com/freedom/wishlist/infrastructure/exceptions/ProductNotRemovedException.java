package com.freedom.wishlist.infrastructure.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ProductNotRemovedException extends RuntimeException {

    public ProductNotRemovedException( String reason) {
        super(reason);
    }
}
