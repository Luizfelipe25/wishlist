package com.freedom.wishlist.infrastructure.services.impl;

import com.freedom.wishlist.core.entities.Wishlist;
import com.freedom.wishlist.infrastructure.dto.ContainsDto;
import com.freedom.wishlist.infrastructure.dto.ProductDto;
import com.freedom.wishlist.infrastructure.dto.ProductsDto;
import com.freedom.wishlist.infrastructure.dto.WishlistDto;
import com.freedom.wishlist.infrastructure.exceptions.ProductNotRemovedException;
import com.freedom.wishlist.infrastructure.exceptions.ProductNotSavedException;
import com.freedom.wishlist.infrastructure.exceptions.WishlistNotFoundException;
import com.freedom.wishlist.infrastructure.repository.WishlistRepository;
import com.freedom.wishlist.infrastructure.services.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;

    private List<String> getProductsList(String userId) {
       List<Wishlist> wishlist= wishlistRepository.findAllByUserId(userId);

       List<String> products = new ArrayList<>();
       wishlist.forEach(list -> products.add(list.getProductId()));
       return products;

    }

    @Override
    public void addProduct(WishlistDto wishlist) {
        List<String> newestProductList = this.getProductsList(wishlist.getUserId());
        boolean alreadyContains = newestProductList.contains(wishlist.getProductId());

        if (newestProductList.size() < 20 && !alreadyContains) {
            this.wishlistRepository.save(Wishlist.builder()
                    .productId(wishlist.getProductId())
                    .userId(wishlist.getUserId())
                    .build());
        } else {
            throw new ProductNotSavedException("A lista ja possui 20 produtos ou o produto ja foi adicionado");
        }
    }

    @Override
    public void removeProduct(WishlistDto wishlist) {
        List<String> newestProductList = this.getProductsList(wishlist.getUserId());

        if(newestProductList.isEmpty()){
            throw new WishlistNotFoundException("lista de desejos do usuario de id " + wishlist.getUserId() + " nao encontrada");
        }
        if(newestProductList.contains(wishlist.getProductId())) {
            this.wishlistRepository.deleteByUserIdAndProductId(wishlist.getUserId(), wishlist.getProductId());
        } else {
            throw new ProductNotRemovedException("A lista de desejos nao possui este produto");
        }
    }

    @Override
    public ProductsDto getProducts(String userId) {
        List<ProductDto> products = new ArrayList<>();

        this.getProductsList(userId).forEach(productId -> products.add(
                ProductDto.builder()
                        .id(productId)
                        .build()
        ));
        return ProductsDto.builder()
                .products(products)
                .build();
    }

    @Override
    public ContainsDto containsProduct(String userId, String productId) {
        List<String> newestProductList = this.getProductsList(userId);

        if(newestProductList.isEmpty()){
            throw new WishlistNotFoundException("lista de desejos do usuario de id " +userId + " nao encontrada");
        }

        if(newestProductList.contains(productId)){
            return ContainsDto.builder().status(true).build();
        }
        return ContainsDto.builder().status(false).build();
    }
}
