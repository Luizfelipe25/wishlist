package com.freedom.wishlist.web.controller;

import com.freedom.wishlist.infrastructure.dto.ContainsDto;
import com.freedom.wishlist.infrastructure.dto.ProductsDto;
import com.freedom.wishlist.infrastructure.dto.WishlistDto;
import com.freedom.wishlist.infrastructure.services.WishlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wishlist")
@RequiredArgsConstructor
@Slf4j
public class WishlistController {

    private final WishlistService wishlistService;

    @PostMapping("/add-product")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addProduct(@RequestBody WishlistDto wishlist){
        this.wishlistService.addProduct(wishlist);
    }

    @DeleteMapping("/remove-product")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProduct(@RequestBody WishlistDto wishlist){
        this.wishlistService.removeProduct( wishlist);
    }

    @GetMapping("/user/{id}/products")
    @ResponseStatus(HttpStatus.OK)
    public ProductsDto getProducts(@PathVariable("id") String userId){
        return this.wishlistService.getProducts(userId);
    }

    @GetMapping("/user/{id}/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ContainsDto checkIfContainsProduct(@PathVariable("id") String userId, @PathVariable("productId") String productId){
        return this.wishlistService.containsProduct(userId,productId);
    }
}
