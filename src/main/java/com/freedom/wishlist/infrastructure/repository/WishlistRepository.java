package com.freedom.wishlist.infrastructure.repository;

import com.freedom.wishlist.core.entities.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface WishlistRepository extends MongoRepository<Wishlist, String> {

    public List<Wishlist> findAllByUserId(String userId);
    public void deleteByUserId(String userId);
    public void deleteByUserIdAndProductId(String userId, String productId);

}
