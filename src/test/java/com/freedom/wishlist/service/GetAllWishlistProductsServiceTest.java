package com.freedom.wishlist.service;

import com.freedom.wishlist.core.entities.Wishlist;
import com.freedom.wishlist.infrastructure.dto.ContainsDto;
import com.freedom.wishlist.infrastructure.dto.ProductDto;
import com.freedom.wishlist.infrastructure.dto.ProductsDto;
import com.freedom.wishlist.infrastructure.exceptions.WishlistNotFoundException;
import com.freedom.wishlist.infrastructure.repository.WishlistRepository;
import com.freedom.wishlist.infrastructure.services.impl.WishlistServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GetAllWishlistProductsServiceTest {

    @InjectMocks
    private WishlistServiceImpl wishlistService;

    @Mock
    private WishlistRepository wishlistRepository;

    @Test
    void should_get_all_wishlist_products() {

        //arrange
        Mockito.when(wishlistRepository.findAllByUserId("1234")).thenReturn(List.of(new Wishlist("99", "1234","99")));
        ProductDto productDTO = ProductDto.builder().id("99").build();

        //act
        ProductsDto productsDto = this.wishlistService.getProducts("1234");

        //assert
        Assertions.assertTrue(productsDto.getProducts().contains(productDTO));

    }
}
