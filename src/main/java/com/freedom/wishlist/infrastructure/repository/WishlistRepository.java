package com.freedom.wishlist.infrastructure.repository;

import com.freedom.wishlist.core.entities.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WishlistRepository extends MongoRepository<Wishlist, String> {

}
