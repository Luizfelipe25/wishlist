package com.freedom.wishlist.web.controller;

import com.freedom.wishlist.infrastructure.dto.ContainsDto;
import com.freedom.wishlist.infrastructure.dto.ProductDto;
import com.freedom.wishlist.infrastructure.dto.ProductsDto;
import com.freedom.wishlist.infrastructure.dto.WishlistDto;
import com.freedom.wishlist.infrastructure.services.WishlistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wishlist")
@RequiredArgsConstructor
@Slf4j
@Tags(@Tag(name = "Wishlist", description = "Wishlist REST Controller"))
public class WishlistController {

    private final WishlistService wishlistService;

    @Operation(
            method = "addProduct",
            description = "Adiciona um produto na lista")
    @PostMapping("/add-product")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto addProduct(@RequestBody WishlistDto wishlist){
       return this.wishlistService.addProduct(wishlist);
    }

    @Operation(
            method = "removeProduct",
            description = "Remove um produto da lista")
    @DeleteMapping("/remove-product")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProduct(@RequestBody WishlistDto wishlist){
        this.wishlistService.removeProduct( wishlist);
    }

    @Operation(
            method = "getProducts",
            description = "Retorna todos os produtos")
    @GetMapping("/user/{id}/products")
    @ResponseStatus(HttpStatus.OK)
    public ProductsDto getProducts(@PathVariable("id") String userId){
        return this.wishlistService.getProducts(userId);
    }

    @Operation(
            method = "checkIfContainsProduct",
            description = "Verifica se um produto esta contido na lista")
    @GetMapping("/user/{id}/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ContainsDto checkIfContainsProduct(@PathVariable("id") String userId, @PathVariable("productId") String productId){
        return this.wishlistService.containsProduct(userId,productId);
    }
}
