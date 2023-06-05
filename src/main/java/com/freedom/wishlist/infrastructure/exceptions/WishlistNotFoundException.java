package com.freedom.wishlist.infrastructure.exceptions;

public class WishlistNotFoundException extends RuntimeException {

    public WishlistNotFoundException(String reason) {
        super(reason);
    }
}
