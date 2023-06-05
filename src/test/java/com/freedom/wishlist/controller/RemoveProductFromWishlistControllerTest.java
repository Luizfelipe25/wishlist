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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RemoveProductFromWishlistControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach(){
        this.wishlistRepository.save(new Wishlist("1","userTestId","1"));
    }

    @Test
    public void should_remove_product_from_wishlist() throws Exception {

        WishlistDto wishlist = new WishlistDto("userTestId", "1");

        mockMvc.perform(post("/api/v1/wishlist/remove-product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(wishlist)))
                .andExpect(status().isNoContent());
    }

    @AfterEach
    private void afterEach(){
        this.wishlistRepository.deleteByUserId("userTestId");
    }

}
