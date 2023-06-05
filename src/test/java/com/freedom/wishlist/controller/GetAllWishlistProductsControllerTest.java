package com.freedom.wishlist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freedom.wishlist.core.entities.Wishlist;
import com.freedom.wishlist.infrastructure.dto.WishlistDto;
import com.freedom.wishlist.infrastructure.repository.WishlistRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GetAllWishlistProductsControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach(){

        this.wishlistRepository.save(new Wishlist("99","1", "1"));
        this.wishlistRepository.save(new Wishlist("98","1", "1"));
    }

    @Test
    public void should_return_all_wishlist_products() throws Exception {

        WishlistDto wishlist = new WishlistDto("1","1");

        mockMvc.perform(get("/api/v1/wishlist/user/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @AfterEach
    private void afterEach(){
        this.wishlistRepository.deleteByUserId("1");
    }
}
