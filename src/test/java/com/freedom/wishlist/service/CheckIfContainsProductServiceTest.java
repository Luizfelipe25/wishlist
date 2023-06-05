package com.freedom.wishlist.service;

import com.freedom.wishlist.core.entities.Wishlist;
import com.freedom.wishlist.infrastructure.dto.ContainsDto;
import com.freedom.wishlist.infrastructure.dto.ProductDto;
import com.freedom.wishlist.infrastructure.dto.WishlistDto;
import com.freedom.wishlist.infrastructure.exceptions.ProductNotSavedException;
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
public class CheckIfContainsProductServiceTest {

    @InjectMocks
    private WishlistServiceImpl wishlistService;

    @Mock
    private WishlistRepository wishlistRepository;

    @Test
    void should_return_true_when_check_if_contains() {

        //arrange
        Mockito.when(wishlistRepository.findAllByUserId("1234")).thenReturn(List.of(new Wishlist("99", "1234","99")));

        //act
        ContainsDto containsDto = this.wishlistService.containsProduct("1234","99");

        //assert
        Assertions.assertTrue(containsDto.getStatus());

    }

    @Test
    void should_return_false_when_check_if_contains() {

        //arrange
        Mockito.when(wishlistRepository.findAllByUserId("1234")).thenReturn(List.of(new Wishlist("99", "1234","99")));

        //act
        ContainsDto containsDto = this.wishlistService.containsProduct("1234","100");

        //assert
        Assertions.assertFalse(containsDto.getStatus());

    }
}
