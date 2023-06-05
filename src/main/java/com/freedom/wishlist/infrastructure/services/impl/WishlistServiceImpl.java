package com.freedom.wishlist.infrastructure.services.impl;

import com.freedom.wishlist.core.entities.Wishlist;
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

}
