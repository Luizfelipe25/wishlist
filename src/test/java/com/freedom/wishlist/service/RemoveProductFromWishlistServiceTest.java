package com.freedom.wishlist.service;

import com.freedom.wishlist.core.entities.Wishlist;
import com.freedom.wishlist.infrastructure.dto.ProductDto;
import com.freedom.wishlist.infrastructure.dto.WishlistDto;
import com.freedom.wishlist.infrastructure.exceptions.ProductNotRemovedException;
import com.freedom.wishlist.infrastructure.exceptions.ProductNotSavedException;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class RemoveProductFromWishlistServiceTest {

    @InjectMocks
    private WishlistServiceImpl wishlistService;

    @Mock
    private WishlistRepository wishlistRepository;

    private List<Wishlist> wishlist;

    @Test
    void should_throw_exception_scenario1_when_remove_product_from_wishlist() {

        //arrange
        Mockito.when(wishlistRepository.findAllByUserId("1234")).thenReturn(new ArrayList<>());

        WishlistDto wishlistDto = new WishlistDto("1234", "99");

        //act
        Executable executable = () -> this.wishlistService.removeProduct(wishlistDto);

        //assert
        assertThrows(WishlistNotFoundException.class, executable);

    }

    @Test
    void should_throw_exception_scenario2_when_remove_product_from_wishlist() {
        //arrange
        Mockito.when(wishlistRepository.findAllByUserId("1234")).thenReturn(List.of(new Wishlist("1","1234","98")));

        WishlistDto wishlistDto = new WishlistDto("1234", "99");

        //act
        Executable executable = () -> this.wishlistService.removeProduct(wishlistDto);

        //assert
        assertThrows(ProductNotRemovedException.class, executable);

    }


}
