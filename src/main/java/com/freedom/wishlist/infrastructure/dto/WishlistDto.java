package com.freedom.wishlist.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Data
public class WishlistDto  implements Serializable {

    private String userId;

    private String productId;

}