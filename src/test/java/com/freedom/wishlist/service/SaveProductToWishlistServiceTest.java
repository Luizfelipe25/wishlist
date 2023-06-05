package com.freedom.wishlist.service;

import com.freedom.wishlist.core.entities.Wishlist;
import com.freedom.wishlist.infrastructure.dto.ProductDto;
import com.freedom.wishlist.infrastructure.dto.WishlistDto;
import com.freedom.wishlist.infrastructure.exceptions.ProductNotSavedException;
import com.freedom.wishlist.infrastructure.repository.WishlistRepository;
import com.freedom.wishlist.infrastructure.services.WishlistService;
import com.freedom.wishlist.infrastructure.services.impl.WishlistServiceImpl;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class SaveProductToWishlistServiceTest {

    @InjectMocks
    private WishlistServiceImpl wishlistService;

    @Mock
    private WishlistRepository wishlistRepository;

    private List<Wishlist> wishlist;


    @Test
    void should_save_product_to_wishlist() {

        //arrange
        Mockito.when(wishlistRepository.findAllByUserId("1234")).thenReturn(List.of(new Wishlist("99", "1234","99")));
        Mockito.when(wishlistRepository.save(any(Wishlist.class))).thenReturn(new Wishlist("99", "1234","100"));

        WishlistDto wishlistDto = new WishlistDto("1234", "100");

        //act
        ProductDto productDto = this.wishlistService.addProduct(wishlistDto);

        //assert

        Assertions.assertEquals(productDto.getId(),"100");

    }

    @Test
    void should_throw_exception_scenario1_when_save_product_to_wishlist() {

        //arrange
        Mockito.when(wishlistRepository.findAllByUserId("1234")).thenReturn(List.of(new Wishlist("99", "1234","99")));

        WishlistDto wishlistDto = new WishlistDto("1234", "99");

        //act
        Executable executable = () -> this.wishlistService.addProduct(wishlistDto);

        //assert
        assertThrows(ProductNotSavedException.class, executable);

    }

    @Test
    void should_throw_exception_scenario2_when_save_product_to_wishlist() {
        List<Wishlist> wishlists = new ArrayList<>();
        
        for(int i =0; i <= 20; i++){
            wishlists.add(new Wishlist("1","1234",String.valueOf(i)));
        }

        //arrange
        Mockito.when(wishlistRepository.findAllByUserId("1234")).thenReturn(wishlists);

        WishlistDto wishlistDto = new WishlistDto("1234", "99");

        //act
        Executable executable = () -> this.wishlistService.addProduct(wishlistDto);

        //assert
        assertThrows(ProductNotSavedException.class, executable);

    }


}
