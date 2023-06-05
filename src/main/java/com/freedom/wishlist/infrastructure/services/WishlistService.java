package com.freedom.wishlist.infrastructure.services;


import com.freedom.wishlist.infrastructure.dto.ContainsDto;
import com.freedom.wishlist.infrastructure.dto.ProductsDto;
import com.freedom.wishlist.infrastructure.dto.WishlistDto;

public interface WishlistService {
    void addProduct(WishlistDto wishlist);

    void removeProduct(WishlistDto wishlist);

    ProductsDto getProducts(String userId);

    ContainsDto containsProduct(String userId, String productId);
}
