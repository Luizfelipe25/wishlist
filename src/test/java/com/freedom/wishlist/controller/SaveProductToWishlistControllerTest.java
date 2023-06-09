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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class SaveProductToWishlistControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void should_save_product_to_wishlist() throws Exception {

        WishlistDto wishlist = new WishlistDto("1234","2");

        mockMvc.perform(post("/api/v1/wishlist/add-product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(wishlist)))
                .andExpect(status().isOk());
    }

    @AfterEach
    private void afterEach(){
        this.wishlistRepository.deleteByUserId("1234");
    }

}
